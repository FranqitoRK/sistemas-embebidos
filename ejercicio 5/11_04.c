#include <stdio.h>
#include <string.h>

#define SIZE 4

struct Persona {
    char nombre[20];
    int edad;
    char sexo; //F,M
    char estudios; //N,P,S,T,U
    char completo; //I,C
};

struct Familia {
    struct Persona integrantes[4];
    int coords; //direccion
    char home; //C,D
    char apellido[20];
};

//info de familias
struct Familia familias[SIZE] = {
    {
        {{"Juan", 40, 'M', 'U', 'C'},
         {"Laura", 38, 'F', 'U', 'C'},
         {"Martina", 15, 'F', 'S', 'I'},
         {"Lucas", 10, 'M', 'P', 'C'}},
        1234, 'C', "Gomez"
    },
    {
        {{"Carlos", 50, 'M', 'S', 'C'},
         {"Ana", 45, 'F', 'S', 'C'},
         {"Pedro", 22, 'M', 'T', 'I'},
         {"Sofia", 18, 'F', 'U', 'I'}},
        5678, 'D', "Ramirez"
    },
    {
        {{"Luis", 35, 'M', 'U', 'C'},
         {"Maria", 33, 'F', 'T', 'C'},
         {"Clara", 12, 'F', 'P', 'C'},
         {"Diego", 8, 'M', 'N', 'I'}},
        9101, 'C', "Fernandez"
    },
    {
        {{"Roberto", 60, 'M', 'S', 'C'},
         {"Elena", 58, 'F', 'S', 'C'},
         {"Lucia", 30, 'F', 'U', 'C'},
         {"Andres", 25, 'M', 'U', 'C'}},
        1121, 'D', "Lopez"
    }
};

//datos con nombre
void print_information(const char nombre[]) {
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < 4; j++) {
            struct Persona p = familias[i].integrantes[j];
            if (strcmp(p.nombre, nombre) == 0) {
                printf("Nombre: %s\nEdad: %d\nSexo: %c\nEstudios: %c\nEstado: %c\n",
                       p.nombre, p.edad, p.sexo, p.estudios, p.completo);
                return;
            }
        }
    }
    printf("Persona no encontrada.\n");
}

//datos generales
void print_list() {
    int total_personas = 0;
    int analfabetos = 0;
    int total_edad_ciudad = 0;
    int estudios_incompletos[5] = {0};// N,P,S,T,U
    int sexo_m = 0, sexo_f = 0;
    int max_terciarios = -1;
    int direccion_max_terciarios = 0;

    char estudios_opciones[] = {'N','P','S','T','U'};

    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < 4; j++) {
            struct Persona p = familias[i].integrantes[j];
            if (p.completo == 'C' && p.estudios != 'N') {
                printf("%s ", p.nombre);
            }
        }
    }
    printf("\n");

    for (int i = 0; i < SIZE; i++) {
        int suma_edad_familia = 0;
        int terciarios_en_dpto = 0;

        for (int j = 0; j < 4; j++) {
            struct Persona p = familias[i].integrantes[j];
            total_personas++;
            suma_edad_familia += p.edad;
            total_edad_ciudad += p.edad;

            if (p.edad > 10 && p.estudios == 'N') {
                analfabetos++;
            }

            if (p.sexo == 'F') sexo_f++;
            else if (p.sexo == 'M') sexo_m++;

            if (p.completo == 'I') {
                for (int k = 0; k < 5; k++) {
                    if (p.estudios == estudios_opciones[k]) {
                        estudios_incompletos[k]++;
                        break;
                    }
                }
            }

            if (familias[i].home == 'D' && p.estudios == 'T') {
                terciarios_en_dpto++;
            }
        }

        float edad_promedio_familia = suma_edad_familia / 4.0;
        printf("Edad promedio de la familia %s: %.2f\n", familias[i].apellido, edad_promedio_familia);

        if (terciarios_en_dpto > max_terciarios) {
            max_terciarios = terciarios_en_dpto;
            direccion_max_terciarios = familias[i].coords;
        }
    }

    float edad_promedio_ciudad = total_edad_ciudad / (float)total_personas;
    float porcentaje_analfabetismo = (analfabetos / (float)total_personas) * 100.0;
    float porcentaje_f = (sexo_f / (float)total_personas) * 100.0;
    float porcentaje_m = (sexo_m / (float)total_personas) * 100.0;

    printf("Porcentaje de analfabetismo: %.2f%%\n", porcentaje_analfabetismo);
    printf("Dirección familia con más terciarios en dpto: %d\n", direccion_max_terciarios);
    printf("Edad promedio de la ciudad: %.2f\n", edad_promedio_ciudad);
    printf("Cantidad de encuestados con estudios incompletos:\n");
    for (int i = 0; i < 5; i++) {
        printf("   - Nivel %c: %d\n", estudios_opciones[i], estudios_incompletos[i]);
    }
    printf("Porcentaje de encuestados:\n   - Femenino: %.2f%%\n   - Masculino: %.2f%%\n", porcentaje_f, porcentaje_m);
}

//filtro con estudios
void filter_by_studies(char estudio) {
    printf("Personas con nivel de estudios %c:\n", estudio);
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < 4; j++) {
            struct Persona p = familias[i].integrantes[j];
            if (p.estudios == estudio) {
                printf("- %s (%s)\n", p.nombre, familias[i].apellido);
            }
        }
    }
}

//filtro por edad
void filter_by_age_greater_than(int edad_minima) {
    printf("Personas con edad mayor o igual a %d:\n", edad_minima);
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < 4; j++) {
            struct Persona p = familias[i].integrantes[j];
            if (p.edad >= edad_minima) {
                printf("- %s (%d años, %s)\n", p.nombre, p.edad, familias[i].apellido);
            }
        }
    }
}

//tipo de vivienda
void filter_by_home_type(char tipo_vivienda) {
    printf("Familias con tipo de vivienda '%c':\n", tipo_vivienda);
    for (int i = 0; i < SIZE; i++) {
        if (familias[i].home == tipo_vivienda) {
            printf("- Familia %s (Dirección: %d)\n", familias[i].apellido, familias[i].coords);
        }
    }
}

//mas uni en familia
void find_family_with_most_university_graduates() {
    int max_graduados = -1,indice_familia = -1;

    for (int i = 0; i < SIZE; i++) {
        int contador = 0;
        for (int j = 0; j < 4; j++) {
            struct Persona p = familias[i].integrantes[j];
            if (p.estudios == 'U' && p.completo == 'C') {
                contador++;
            }
        }
        if (contador > max_graduados) {
            max_graduados = contador;
            indice_familia = i;
        }
    }

    if (indice_familia != -1) {
        printf("Familia con más graduados universitarios: %s (%d graduados)\n",
               familias[indice_familia].apellido, max_graduados);
    }
}

int main() {
    int opcion;
    char nombre[20];

    do {
        printf("\n=== Menú ===\n");
        printf("1. Ver estadísticas generales\n");
        printf("2. Buscar persona por nombre\n");
        printf("3. Familia con más graduados universitarios\n");
        printf("4. Filtrar por estudios\n");
        printf("5. Filtrar por edad mínima\n");
        printf("6. Filtrar por tipo de vivienda\n");
        printf("7. Salir\n");
        printf("Seleccione una opción: ");
        scanf("%d", &opcion);

        switch(opcion) {
            case 1:
                print_list();
                break;
            case 2:
                printf("Ingrese el nombre de la persona (sin espacios): ");
                scanf("%s", nombre);
                print_information(nombre);
                break;
            case 3:
                find_family_with_most_university_graduates();
                break;
            case 4: {
                char est;
                printf("Ingrese el nivel de estudios (N, P, S, T, U): ");
                scanf(" %c", &est);
                filter_by_studies(est);
                break;
            }
            case 5: {
                int edad;
                printf("Ingrese la edad mínima: ");
                scanf("%d", &edad);
                filter_by_age_greater_than(edad);
                break;
            }
            case 6: {
                char tipo;
                printf("Ingrese el tipo de vivienda (C para casa, D para depto): ");
                scanf(" %c", &tipo);
                filter_by_home_type(tipo);
                break;
            }
            case 7:
                printf("Saliendo del programa...\n");
                break;
            default:
                printf("Opción no válida.\n");
        }
    } while (opcion != 7);

    return 0;
}
