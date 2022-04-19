import numpy as np
import pandas as pd


class PCA:

    def __init__(self, k):
        """
        :param k:
        :return:
        """
        self.feature = None
        self.index = None
        self.eig_vec = None
        self.eig_val = None
        self.SVD_matrix = None
        self.norm_X = None
        self.mean = None
        self.n_features = None
        self.n_samples = None
        self.k = k
        self.sample_num = None
        self.feature_num = None

    def fit(self, data):
        self.n_samples, self.n_features = data.shape
        self.mean = np.mean(data, axis=0)
        self.norm_X = data - self.mean
        self.SVD_matrix = np.dot(self.norm_X.T, self.norm_X)

        self.eig_val, self.eig_vec = np.linalg.eig(self.SVD_matrix)
        self.index = np.argsort(-np.abs(self.eig_val))
        self.feature = self.eig_vec[:, self.index[:self.k]]

    def transform(self):
        return np.dot(self.norm_X, self.feature)
