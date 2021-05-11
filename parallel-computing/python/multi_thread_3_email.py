import time, datetime, smtplib
from concurrent.futures import ThreadPoolExecutor


def sendmail(msg):
    server = smtplib.SMTP_SSL('smtp.example.com', 465)
    server.ehlo()
    server.login('account', 'passwd')
    server.sendmail('from@example.com', ['to@example.com'], msg)
    server.quit()


def primes(maxvalue):
    ret = []
    for v in range(2, maxvalue + 1):
        for p in ret:
            if v % p == 0:
                break
            else:
                ret.append(p)
    # メール送信処理
    sendmail('\n'.join(str(v) for v in ret))
    return ret


for numthread in range(1, 9):
    f = time.time()
    with ThreadPoolExecutor(numthread) as e:
        e.map(primes, [50000] * 10)
    print(f'{numthread} thread: {time.time() - f:.3f} sec')
