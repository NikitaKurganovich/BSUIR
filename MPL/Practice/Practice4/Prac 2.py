import numpy as np
import matplotlib
from matplotlib import pyplot as plt

x = np.linspace(0, 1, 100) # get equal distribution of values in range 0, 1
f1 = 0.25 - (x - 0.5) ** 2 # get y's of x values
f2 = x ** 3                # --//--

plt.plot(x, f1, '>b') # draw 3 graphics in different styles 
plt.plot(x, f2, '--r')
plt.plot(x, f1 + f2, 'k')

# set axis ranges
plt.xlim([0, 1])
plt.ylim([0, 1])

# set font 
matplotlib.rcParams.update({'font.size': 14})

# axis lables
plt.xlabel('run number', fontsize=16)
# TeX version
plt.ylabel(r'average current ($\mu A$)', fontsize=16)

plt.show()
