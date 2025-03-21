#include <stdio.h>
//Se realiza una inspección en una fábrica de pinturas, y se detectaron 20 infracciones. De cada infracción se tomó nota de los siguientes datos:-Tipo de Infracción (1, 2, 3, ó 4) -Valor de la multa -Gravedad de la infracción (‘L’,‘M’, ‘G’) Se pide informar al final del proceso: Los valores totales de la multa a pagar de acuerdo al tipo de gravedad. La leyenda “Clausurar fábrica” si la cantidad de infracciones 3 y 4 con gravedad “G” sean mayor a 3.
struct Infraccion{
    int tipo;
    int cantidad;
    char gravedad;
};
struct Infraccion infracciones[5];

int main() {
    int i,multal=0,multam=0,multag=0,cf=0;
    for(i=0;i<5;i++){
        printf("ingrese el tipo de infraccion: ");
        scanf("%d",&infracciones[i].tipo);
        printf("ingrese el valor de la infraccion: ");
        scanf("%d",&infracciones[i].cantidad);
        printf("ingrese la gravedad de la infraccion (L,M,G): ");
        scanf("%s",&infracciones[i].gravedad);
        total=total+infracciones[i].cantidad;
        if(infracciones[i].gravedad=='G' || infracciones[i].gravedad=='g'){
            if(infracciones[i].tipo>=3){
                cf++;   
            }
        }
    }
    //printf("total a pagar: %d\n",total);
    //hacer una multa para cada gravedad y printear
    if(cf>=3){
        printf("clausurar fabrica");
    }
    return 0;
}