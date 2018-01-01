import numpy as np


matrix1 = np.mat(np.arange(12).reshape((3, 4)))
print type(matrix1)         # <class 'numpy.matrixlib.defmatrix.matrix'>


# matrix.getA()
# Return `self` as an `ndarray` object.Equivalent to ``np.asarray(self)``.
na1 = matrix1.getA()
print type(na1)             # <type 'numpy.ndarray'>