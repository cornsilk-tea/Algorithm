#include<stdio.h>
int main() {
	int a,i,num;
	int max = -1000000;
	int law = 1000000;
	scanf("%d", &num);
	for (i = 0; i < num; i++) {
		scanf("%d", &a);
		if (a >= max) max = a;
		if (a <= law) law = a;
	}
	printf("%d %d", law, max);
}