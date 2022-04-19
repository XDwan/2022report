from layer.linear import Linear
from layer.func import Relu,Sigmoid
from network import Network
from data.normal_data import xor_data
import numpy as np
dataset = xor_data()

model = Network()
model.add_layer(Linear(3,2))
model.add_layer(Relu())
model.add_layer(Linear(2,1))
model.add_layer(Sigmoid())

# print(model.layers[0].w.shape)
# print(model.layers[1].w.shape)

for ite in range(1000):
    for x, label in dataset:
        # print(x.shape)
        y_pred = model.forward(x).reshape((1,1))
        
        # print(y_pred)
        if label == 0:
            loss_grad = (y_pred - label) * np.log(1 - y_pred)
        else:
            loss_grad = -(y_pred - label) * np.log(y_pred)
        loss_grad = y_pred - label
        model.auto_grad(loss_grad)
        model.backward(0.1)

model.summary()

for x, label in dataset:
        # print(x.shape)
        y_pred = model.forward(x)
        print("x1 x2 x3   y  y_pred")
        print(str(x.reshape(-1).tolist())+"  "+str(label)+"  "+str(y_pred.reshape(-1).tolist()))
        # print(label)
        # loss_grad = y_pred - label
        # model.auto_grad(loss_grad)
        # model.backward(0.01)
