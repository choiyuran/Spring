import requests  # pip install requests
from bs4 import BeautifulSoup
import time

# nate 실시간 검색어 가져오기
requests.encoding = 'utf-8'
url = 'https://www.nate.com/'

dataList = []

while len(dataList) < 25:
    resp = requests.get(url)
    code = resp.text
    soup = BeautifulSoup(code, 'html.parser')
    ol = soup.select_one('ol#olLiveIssueKeyword')
    # js의 document.querySelector()와 같이 선택자로 하나만 가져온다.

    numRankList = ol.select('span.num_rank')
    # js의 document.querySelectorAll()과 같이 선책자로 여러 태그를 가져온다.
    #'<span class="num_rank">1</span>'

    txtRankList = ol.select('span.txt_rank')

    numRankList = list(map(lambda x: x.text, numRankList))
    txtRankList = list(map(lambda x: x.text, txtRankList))

    for num, txt in zip(numRankList, txtRankList):
        dataList.append(f"{num} : {txt}")
    time.sleep(0.5)

resultList = list(set(dataList))
resultList.sort(key=lambda x: (int)(x.split(' : ')[0]))

print('네이트 실시간 이슈 키워드')
print('=' * 25)
for item in resultList:
    print(item)
print('='*25)
