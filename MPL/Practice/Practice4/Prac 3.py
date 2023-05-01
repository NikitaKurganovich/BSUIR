# Working with titles
import numpy as np
import matplotlib.pyplot as plt
import matplotlib

matplotlib.rcParams.update({'font.size':12})

rng = np.random.default_rng(11) # equal to np.random.Generator(np.random.PGC64(11))

x = np.arange(6)  # return evenly spaced values within a given interval.
y = rng.poisson(149, x.size) # poisson distribution

# 
yerr = [0.7 * np.sqrt(y), 1.2 * np.sqrt(y)]

plt.errorbar(x, y, yerr=yerr, marker='o', linestyle='none', ecolor='k', elinewidth=0.8, capsize=4, capthick=1)

# добавляем подписи к осям и заголовок диаграммы
plt.xlabel('run number', fontsize=16)
plt.ylabel(r'average current ($\mu A$)', fontsize=16)
plt.title(r'The $\alpha^\prime$ experiment. Season 2020-2021')
# задаем диапазон значений оси y
plt.ylim([0, 200])
# оптимизируем поля и расположение объектов
plt.tight_layout()
plt.show()

plt.show()



