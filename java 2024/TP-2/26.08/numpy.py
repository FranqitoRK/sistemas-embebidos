#cd (carpeta donde esta python)
#python.exe -m pip install matplotlib
#python.exe -m pip install numpy

import matplotlib.pyplot as plt
import numpy as np

uniforme=np.random.rand(1000)*8 #crea valores(lista)
media=np.mean(uniforme)
desvio=np.std(uniforme)
plt.plot(uniforme)
plt.plot([0,1000],[media,media]) #grafica la media
plt.plot([0,1000],[media+desvio,media+desvio]) #grafica junto al desvio inferior el 65% de los valores
plt.plot([0,1000],[media-desvio,media-desvio])

normy=np.random.normal(0,1,1000)
plt.plot(normy)

plt.show() #show tiene que quedar ultimo
