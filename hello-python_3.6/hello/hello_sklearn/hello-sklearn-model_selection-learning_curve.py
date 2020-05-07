# -*- coding: utf-8 -*-

import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

from sklearn import datasets
from sklearn.datasets import load_digits
from sklearn.model_selection import learning_curve, ShuffleSplit
from sklearn.naive_bayes import GaussianNB
from sklearn import svm

'''加载数据'''
digits = load_digits()
X = digits.data
y = digits.target

