import time, datetime
from concurrent.futures import ThreadPoolExecutor

def primes(maxvalue):
    ret = []
    for v in range(2, maxvalue + 1):
        for p in ret:
            if v % p == 0:
                break
            else:
                ret.append(p)
    return ret

for numthread in range(1, 5):
    f = time.time()
    with ThreadPoolExecutor(numthread) as e:
        e.map(primes, [50000] * 10)
    print(f'{numthread} thread: {time.time() - f:.3f} sec')
