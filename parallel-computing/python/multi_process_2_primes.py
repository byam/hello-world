import time, datetime
from concurrent.futures import ProcessPoolExecutor

def primes(maxvalue):
    ret = []
    for v in range(2, maxvalue + 1):
        for p in ret:
            if v % p == 0:
                break
            else:
                ret.append(p)
    return ret

def main():
    for numthread in range(1, 9):
        f = time.time()
        start = datetime.datetime.now() # 開始時間を記録
        with ProcessPoolExecutor(numthread) as e:
            e.map(primes, [500000] * 100)
        print(f'{numthread} thread: start: {start} {time.time() - f:.3f} sec')

if __name__ == '__main__':
    main()
