#include <stdio.h>
struct Contenedor{
    int id;
    int peso;
    int puerto;
};

struct Contenedor contenedores[3];

void preguntas(struct Contenedor *contenedorvacio){
    //"->" para los punteros, "." para las variables directas
    printf("\nIngrese la identificacion del contenedor: ");
    scanf("%d",&contenedorvacio->id);
    printf("Ingrese el peso en kg del contenedor: ");
    scanf("%d",&contenedorvacio->peso);
    printf("Ingrese el puerto al que va el contenedor (1,2,3): ");
    scanf("%d",&contenedorvacio->puerto);
}

int main() {
    int i,pesototal=0,mayorpeso=0,puerto1=0,puerto2=0,puerto3=0,idmayorpeso;
    for(i=0;i<3;i++){
        
        preguntas(&contenedores[i]);
        
        pesototal=pesototal+contenedores[i].peso;
        if(mayorpeso<contenedores[i].peso){
            mayorpeso=contenedores[i].peso;
            idmayorpeso=contenedores[i].id;
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
    printf("\nEl contenedor con la carga mas pesada es el #%d",idmayorpeso);
    printf("\nSe deben dejar %d contenedores en el puerto 1, %d contenedores en el puerto 2 y %d contenedores en el puerto 3",puerto1,puerto2,puerto3);
    return 0;
}