import numpy as np
import math
from matplotlib import pyplot as plt


# generate range of evenly spaced numbers
phi = np.linspace(0, 2 * np.pi, 100)

# create sin & cos graphics
plt.plot(phi, np.sin(phi))
plt.plot(phi, np.cos(phi))

# show
plt.show()
