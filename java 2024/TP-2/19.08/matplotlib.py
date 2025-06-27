#cd (carpeta donde esta python)
#python.exe -m pip install matplotlib

import matplotlib.pyplot as plt
suma=0.0
with open("orden.txt","r")as archivo:
        numeros=[float(linea.strip())for linea in archivo]
for i in range (len(numeros)):
    suma=suma+(numeros[i])
indices=list(range(len(numeros)))
largo=len(numeros)
promedio=(suma/largo)
plt.plot(indices,numeros,marker="o")
plt.axhline(promedio,color="r")
plt.xlabel("Tiempo")
plt.ylabel("Amplitud")
plt.title("Gráfico")
plt.show() #show tiene que quedar ultimo


