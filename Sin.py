import os
import openai
openai.api_key = "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"
response = openai.Image.create(
  prompt="fight between v1 and gabriel from ultrakill. ultrakill graphics style",
  n=2,
  size="1024x1024"
)
print(response)