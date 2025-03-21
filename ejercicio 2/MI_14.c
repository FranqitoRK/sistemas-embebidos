#include <stdio.h>
//Dados 50 números enteros, informar el promedio de los mayores que 100 y la suma de los menores que –10.
int main() {
    int in[5];
    int i,div=0,prom=0,suma=0,promf=0;
    for(i=0;i<5;i++){
        printf("ingrese numero %d: ",i+1);
        scanf("%d",&in[i]);
        if(in[i]>100){
            prom=prom+in[i];
            div=div+1;
        }
        if(in[i]<-10){
            suma=suma+in[i];
        }
    }
    if(div!=0){
        promf=prom/div;
    }
    printf("el promedio de numeros mayores a 100 es de %d\n",promf);
    if(suma!=0){
        printf("la suma de numeros menores a -10 es de %d\n",suma);
    }
    return 0;
}