import numpy as np
import pandas as pd
from pca import PCA


def var(X):
    d = np.array(X).reshape(-1)
    return np.sum(np.abs(d - np.mean(d)) ** 2) / (d.shape[0] - 1)


data = pd.read_table("ColorHistogram.asc", sep="\\s+", header=None, index_col=0)

p = PCA(5)

p.fit(data)

out = p.transform()

print("降维前的样本方差：")
for col in data.columns:
    print(var(data[col]))

print("降维后的样本方差为：")
for col in out.T:
    print(var(col))
