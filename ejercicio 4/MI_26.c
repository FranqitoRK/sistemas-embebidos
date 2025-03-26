#include <stdio.h>
struct Contenedor{
    int identificacion;
    int peso;
    int puerto;
};
struct Contenedor contenedores[100];

int main() {
    int i,pesototal=0,mayorpeso=0,puerto1=0,puerto2=0,puerto3=0,idenmayorpeso;
    for(i=0;i<100;i++){
        printf("ingrese la identificacion del contenedor: ");
        scanf("%d",&contenedores[i].identificacion);
        printf("ingrese el peso en kg del contenedor: ");
        scanf("%d",&contenedores[i].peso);
        printf("ingrese el puerto al que va el contenedor (1,2,3): ");
        scanf("%d",&contenedores[i].puerto);
        pesototal=pesototal+contenedores[i].peso;
        if(mayorpeso<contenedores[i].peso){
            idenmayorpeso=contenedores[i].identificacion;
        }
        if(contenedores[i].puerto==1){
            puerto1++;
        }
        if(contenedores[i].puerto==2){
            puerto2++;
        }
        if(contenedores[i].puerto==3){
            puerto3++;
        }
    }
    printf("\nEl peso total de la carga del buque es de %d kg",pesototal);
    printf("\nEl contenedor con la carga mas pesada es el #%d",idenmayorpeso);
    printf("\nSe deben dejar %d contenedores en el puerto 1, %d contenedores en el puerto 2 y %d contenedores en el puerto 3",puerto1,puerto2,puerto3);
    return 0;
}