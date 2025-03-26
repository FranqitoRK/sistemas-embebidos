#include <stdio.h>

#define test 3

struct Sensor{
    int sensor_id; //2num
    int timestamp; //epoch/unix timestamp
    int value_type; //1temperature, 2pressure, 3flow, 4level
    int value; //3num
};

struct Sensor sensores[test];

void info(struct Sensor *sensorvacio){
    printf("\nIngrese el ID del sensor: ");
    scanf("%d",&sensorvacio->sensor_id);
    printf("Ingrese el timestamp en formato Unix: ");
    scanf("%d",&sensorvacio->timestamp);
    printf("Ingrese el tipo de valor: ");
    scanf("%d",&sensorvacio->value_type);
    printf("Ingrese el valor medido: ");
    scanf("%d",&sensorvacio->value);
}

int main() {
    int i,get_highest_value=0,get_lowest_value=0,get_average_value=0,total=0;
    //get_range_value,find_sensor_by_id,get_sensor_information;
    
    for(i=0;i<test;i++){
        info(&sensores[i]);
        if(get_highest_value<sensores[i].value || i==0){
            get_highest_value=sensores[i].value;
        }
        if(get_lowest_value>sensores[i].value || i==0){
            get_lowest_value=sensores[i].value;
        }
        total=total+sensores[i].value;
    }
    get_average_value=total/test;
    printf("\nvalor mas alto: %d\nvalor mas bajo: %d\nvalor promedio: %d",get_highest_value,get_lowest_value,get_average_value);
    
    return 0;
}