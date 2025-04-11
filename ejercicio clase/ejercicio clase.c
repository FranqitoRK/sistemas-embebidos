//modificado a partir de la clase del 09/04

#include <stdio.h>
#define size 3

struct Sensor {
    int id; // 2 num
    int timestamp; // epoch/unix timestamp
    int value_type; // 1=temperature, 2=pressure, 3=flow, 4=level
    int value; // 3 num
};

struct Sensor sensores[size];

void info(struct Sensor *sensorvacio) {
    printf("\nIngrese el ID del sensor: ");
    scanf("%d", &sensorvacio->id);
    printf("Ingrese el timestamp en formato Unix: ");
    scanf("%d", &sensorvacio->timestamp);
    printf("Ingrese el tipo de valor(1=temperature, 2=pressure, 3=flow, 4=level): ");
    scanf("%d", &sensorvacio->value_type);
    printf("Ingrese el valor medido: ");
    scanf("%d", &sensorvacio->value);
}

int get_highest_value(struct Sensor sensores[]) {
    int highest_value = sensores[0].value;
    for (int i = 1; i < size; i++) {
        if (sensores[i].value > highest_value) {
            highest_value = sensores[i].value;
        }
    }
    return highest_value;
}

int get_lowest_value(struct Sensor sensores[]) {
    int lowest_value = sensores[0].value;
    for (int i = 1; i < size; i++) {
        if (sensores[i].value < lowest_value) {
            lowest_value = sensores[i].value;
        }
    }
    return lowest_value;
}

float get_average_value(struct Sensor sensores[]) {
    int sum = 0;
    for (int i = 0; i < size; i++) {
        sum += sensores[i].value;
    }
    return (float)sum / size;
}

const char* get_value_type_name(int value_type) {
    switch (value_type) { //nueva estructura desbloqueada
        case 1: return "temperature";
        case 2: return "pressure";
        case 3: return "flow";
        case 4: return "level";
        default: return "Unknown";
    }
}

void get_range_value(struct Sensor sensores[], int *highest_value, int *lowest_value) {
    *highest_value = get_highest_value(sensores);
    *lowest_value = get_lowest_value(sensores);
}

struct Sensor find_sensor_by_id(struct Sensor sensores[], int id) {
    struct Sensor found_sensor = {0}; //Inicializamos con valores por defecto (??)
    for (int i = 0; i < size; i++) {
        if (sensores[i].id == id) {
            return sensores[i];
        }
    }
    return found_sensor;
}

void get_sensor_information(struct Sensor sensores[], int id) {
    struct Sensor sensor = find_sensor_by_id(sensores, id);
    
    int highest_value, lowest_value;
    get_range_value(sensores, &highest_value, &lowest_value);
    
    float average = get_average_value(sensores);
    
    printf("Sensor ID: %d\n", sensor.id);
    printf("Timestamp: %d\n", sensor.timestamp);
    printf("Tipo de valor: %s\n", get_value_type_name(sensor.value_type));
    printf("Valor: %d\n", sensor.value);
    printf("Rango: %d - %d\n", highest_value, lowest_value);
    printf("Promedio: %.2f\n", average);
}

int main() {
    for (int i = 0; i < size; i++) {
        info(&sensores[i]);
    }

    int user_id;
    printf("Ingrese un ID de sensor: ");
    scanf("%d", &user_id);

    get_sensor_information(sensores, user_id);
    
    return 0;
}
