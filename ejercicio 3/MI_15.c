#include <stdio.h>
struct Infraccion{
    int tipo;
    int cantidad;
    char gravedad;
};
struct Infraccion infracciones[20];

int main() {
    int i,multal=0,multam=0,multag=0,cf=0;
    for(i=0;i<20;i++){
        printf("ingrese el tipo de infraccion: ");
        scanf("%d",&infracciones[i].tipo);
        printf("ingrese el valor de la infraccion: ");
        scanf("%d",&infracciones[i].cantidad);
        printf("ingrese la gravedad de la infraccion (L,M,G): ");
        scanf("%s",&infracciones[i].gravedad);
        if(infracciones[i].gravedad=='G' || infracciones[i].gravedad=='g'){
            multag=multag+infracciones[i].cantidad;
            if(infracciones[i].tipo>=3){
                cf++;   
            }
        }
        if(infracciones[i].gravedad=='L' || infracciones[i].gravedad=='l'){
            multal=multal+infracciones[i].cantidad;
        }
        if(infracciones[i].gravedad=='M' || infracciones[i].gravedad=='m'){
            multam=multam+infracciones[i].cantidad;
        }
    }
    printf("\nTotal a pagar:\n-Multas G: $%d\n-Multas M: $%d\n-Multas L: $%d",multag,multam,multal);
    if(cf>=3){
        printf("\nCLAUSURAR FABRICA");
    }
    return 0;
}