# Refraction Conversions

_A program to help with converting refractions in optometry and ophthalmology between plus and minus cylinder notation._

---
The two basic pieces of this program are the Refraction class and the RefractionConverter 
I put these two classes in a module, so they can be reused by other components later.
The emphasis is on readability of the code to not clutter it up with an excessive amount of comments.
I strive for full variable names in place of abbreviations to further this goal.

---

There are a few things that still need clarification and may require the package to be touched up in the future.
All of them are marked with `TODO` comments and are summarised here.
* It was unclear if words like `generally` and `normally` in the requirements meant that the model should enforce them strictly, so I left that part out.
* It was up to me to develop exactly how the input and display was handled, so I went with a text file reading line by line. This led to needing a text parser that depends upon a specific format`-3.75 +2.00 x154`. That format would is only intended to work with the requirement specified format, not the data types associated with the three values.  




