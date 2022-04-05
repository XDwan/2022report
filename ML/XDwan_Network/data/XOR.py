import numpy as np

def xor_data():

    X = np.array([
                [0,0,0],
                [0,0,1],
                [0,1,0],
                [0,1,1],
                [1,0,0],
                [1,0,1],
                [1,1,0],
                [1,1,1]   
                ])
    X = X.reshape([8,3,1])
    y = np.array([0,1,1,0,1,0,0,1])
    return 