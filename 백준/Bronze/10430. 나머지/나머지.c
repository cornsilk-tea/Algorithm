/*첫째 줄에 (A+B)%C, 
둘째 줄에 ((A%C) + (B%C))%C, 
셋째 줄에 (A×B)%C, 
넷째 줄에 ((A%C) × (B%C))%C를 출력한다.
*/
#include<stdio.h>
int main()
{
    int A, B, C, result;
    scanf("%d %d %d\n", &A, &B, &C);
    result = (A+B)%C;
    printf("%d\n",result );
    
    result = ((A%C) + (B%C))%C;
    printf("%d\n",result );
    
    result = (A*B)%C;
    printf("%d\n",result);
    
    result = ((A%C) * (B%C))%C;
    printf("%d\n",result);
}