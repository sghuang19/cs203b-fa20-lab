import random
import numpy as np


def read_dim():
    f = open('matrices.txt', 'r')
    dim = 0
    while f.readline() != '\n':
        dim = dim + 1
        pass
    return dim


def read(dim_r):
    # dim_r = 10
    f = open('matrices.txt')
    matrix1 = np.zeros((dim_r, dim_r), dtype=float)
    for i in range(dim_r):
        line = list(map(float, f.readline().split()))
        # print(l)
        # print(matrix)
        for j in range(dim_r):
            matrix1[i][j] = line[j]
            print(line[j])
            pass
        pass

    f.readline()
    matrix2 = np.zeros((dim_r, dim_r), dtype=float)
    for i in range(dim_r):
        line = list(map(float, f.readline().split()))
        for j in range(dim_r):
            matrix2[i][j] = line[j]
            print(line[j])
            pass
        pass
    return matrix1, matrix2


def generate(dim_g):
    dim = 10
    f = open('matrices.txt', 'w')
    for i in range(dim_g):
        for i in range(dim_g):
            f.write(str(random.random()) + ' ')
        pass
        f.write('\n')
    pass

    f.write('\n')

    for i in range(dim_g):
        for i in range(dim_g):
            f.write(str(random.random()) + ' ')
        pass
        f.write('\n')
    pass

    f.write('\n')
    pass


def multiply(matrix1, matrix2):
    pass


generate(3)
matrices = read(read_dim())
print(np.multiply(matrices[0], matrices[1]))
