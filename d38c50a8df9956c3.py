import time

import requests


url = 'https://www.naver.com'
resp = requests.get(url)
html = resp.text.strip()

print(f"resp : {resp}")
print(f"resp.text : {html[:20]} ... {html[-20:]}")
print(f"len(resp.text) : {len(resp.text)}")
print()

url = 'https://search.naver.com/search.naver'
param = {'query': '아이유'}


resp = requests.get(url, param)
print('resp :', resp)
print(f"resp : {resp}")
print(f"resp.text : {html[:20]} ... {html[-20:]}")
print(f"{param['query']}가 문서에 포함된 횟수 : {resp.text.count(param['query'])}")
