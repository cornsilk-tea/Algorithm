#include<stdio.h>
int cycle(int n, int count);
int main()
{
  int n;//34
	int result, count;
	count = 1;
  scanf("%d", &n);//34
  result = cycle(n, count);
	while(1)
	{
		if(result != n)//47 != 34
			result = cycle(result, count);
		else if(result == n)
		{
			printf("%d", count);
			return 0;
		}
		count++;
	}
}
int cycle(int n, int count)
{
  int A, B, result;
  B = n%10;//34%10=4
  A = (n/10);//34/10=3.4(int임으로 3으로 남는다.)
	result = A + B;//3 + 4 = 7
	if(result >= 10)
	{
		result = result - 10;
	}
	result = B*10 + result;
	return result;		
}