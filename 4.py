from bs4 import BeautifulSoup
import requests

url = 'https://search.naver.com/search.naver'
param = {'query': input('검색어를 입력하세요 : ')}
resp = requests.get(url, param)
html = resp.text
soup = BeautifulSoup(html, 'html.parser')

# select로 선택자형식을 활용한 후 그 태그들의 텍스트만 출력
for i in soup.select('div.tit'):
    print(i.text)
print()
