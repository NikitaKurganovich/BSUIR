import numpy as np
import matplotlib.pyplot as plt
import matplotlib

rng = np.random.default_rng(5)

data1 = rng.poisson(145, 10000)
data2 = rng.poisson(140, 2000)

data = [data1, data2]

plt.hist(data, bins=40)
plt.hist(data, bins=40, histtype='step')
plt.hist(data, bins=40, stacked=True)


def poisson_hist(data, bins=60, lims=None):
    hist, bins = np.histogram(data, bins=bins, range=lims)
    bins = 0.5 * (bins [1:] + bins[:-1])
    return (bins, hist, np.sqrt(hist))

rg = np.random.Generator(np.random.PCG64(5))
data = rg.poisson(145, 10000)
x, y, yerr = poisson_hist(data, bins=40, lims=(100, 190))
plt.errorbar(x, y, yerr=yerr, marker='o', markersize=4,
linestyle='none', ecolor='k', elinewidth=0.8,
capsize=3, capthick=1)

plt.show()

