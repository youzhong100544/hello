# -*- coding: utf-8 -*-

def f(x):
    return x*x

if __name__ == '__main__':
    l = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    m = map(f, l)
    print(m) #<map object at 0x000002020D4505F8>

    print(list(m)) #[1, 4, 9, 16, 25, 36, 49, 64, 81]


