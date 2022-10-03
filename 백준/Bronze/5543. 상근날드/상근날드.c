/*상근날드에서 가장 잘 팔리는 메뉴는 세트 메뉴이다. 주문할 때, 자신이 원하는 햄버거와 음료를 하나씩 골라, 세트로 구매하면, 가격의 합계에서 50원을 뺀 가격이 세트 메뉴의 가격이 된다.
햄버거는 총 3종류 상덕버거, 중덕버거, 하덕버거가 있고, 음료는 콜라와 사이다 두 종류가 있다.
햄버거와 음료의 가격이 주어졌을 때, 가장 싼 세트 메뉴의 가격을 출력하는 프로그램을 작성하시오.

입력은 총 다섯 줄이다. 
첫째 줄에는 상덕버거, 800
둘째 줄에는 중덕버거, 700
셋째 줄에는 하덕버거의 가격이 주어진다. 900
넷째 줄에는 콜라의 가격, 198
다섯째 줄에는 사이다의 가격이 주어진다. 330
결과값 848
*/
#include<stdio.h>
int calham();
int caldrin();
int main()
{
	int hamburger, drink;
	hamburger = calham();
	drink = caldrin();
	printf("%d", hamburger + drink - 50);
}
int calham()
{
	int result=0, price;
	scanf("%d", &price);
	result = price;
	for(int n = 1; n < 3; n++)
	{
		scanf("%d", &price);
			if(price < result)
				result = price;
	}
	
	return result;
}
int caldrin()
{
	int result = 0, price;
	scanf("%d", &price);
	result = price;
	for(int n = 1; n < 2; n++)
	{
		scanf("%d", &price);
		if(price < result)
			result = price;
	}
	return result;
}