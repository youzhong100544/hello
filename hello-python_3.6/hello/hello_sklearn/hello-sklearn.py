# -*- coding: utf-8 -*-

import numpy as np
import pandas as pd

import matplotlib.pyplot as plt

import sklearn
print("scikit-learn(sklearn) version: {}". format(sklearn.__version__))

from sklearn.preprocessing import OneHotEncoder, LabelEncoder

from sklearn.cluster import KMeans
from  sklearn.cluster import k_means

from sklearn.datasets import make_blobs

# from sklearn import svm, tree, linear_model, neighbors, naive_bayes, ensemble, discriminant_analysis, gaussian_process

from sklearn import svm
from sklearn import tree
from sklearn import linear_model
from sklearn import neighbors
from sklearn import naive_bayes
from sklearn import ensemble
from sklearn import discriminant_analysis
from sklearn import gaussian_process

from sklearn import feature_selection
from sklearn import model_selection
from sklearn import metrics

from sklearn.feature_extraction.text import CountVectorizer
from sklearn.metrics.pairwise import euclidean_distances
from sklearn.feature_extraction.text import TfidfVectorizer

ls_a = {"A": [1, 1, 2, 2, 2, 3], "B": [2, 5, 8, 7, 9, 4], "C": [3, 6, 9, 9, 9, 9]}
df = pd.DataFrame(ls_a)

print(df)


