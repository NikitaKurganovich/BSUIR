from matplotlib import pyplot as plt
import pandas as pd

plt.rcParams["figure.figsize"] = [7.50, 3.50]
plt.rcParams["figure.autolayout"] = True

df1 = pd.DataFrame(dict(a=[1, 1, 1, 1, 3]))
df2 = pd.DataFrame(dict(b=[1, 1, 2, 1, 3]))

df3 = pd.DataFrame(dict(c=[1, 4, 1, 1, 3]))
df4 = pd.DataFrame(dict(d=[1, 5, 6, 1, 3]))

fig, axs = plt.subplots(nrows=2, ncols=2, figsize=(8, 8))

df1.hist( ax=axs[0, 0])
df2.hist( ax=axs[1, 0])
df3.hist( ax=axs[1, 1])
df4.hist( ax=axs[0, 1])

plt.show()
