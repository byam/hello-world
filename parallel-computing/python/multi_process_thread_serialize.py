import time, datetime
from concurrent.futures import ProcessPoolExecutor, ThreadPoolExecutor

def copy(param):
    return param

class Param:
    def __init__(self, v):
        self.v = v

values = [Param(i) for i in range(100000)]


def main():
    # マルチプロセス
    with ProcessPoolExecutor() as e:
        f = time.time()
        ret = e.submit(copy, values).result()
        print(f'ProcessPoolExecutor: {time.time() - f:.3f} sec')

    # マルチプロセス
    with ThreadPoolExecutor() as e:
        f = time.time()
        ret = e.submit(copy, values).result()
        print(f'ThreadPoolExecutor: {time.time() - f:.3f} sec')

if __name__ == '__main__':
    main()
