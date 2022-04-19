import numpy as np
import pandas as pd
from sklearn.decomposition import PCA

data = pd.read_table("ColorHistogram.asc", sep="\\s+", header=None, index_col=0)

pca = PCA(n_components=5)

out = pca.fit_transform(data)
