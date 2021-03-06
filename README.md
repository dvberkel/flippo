Flippo [![Build Status](https://travis-ci.org/dvberkel/flippo.svg?branch=master)](https://travis-ci.org/dvberkel/flippo)
======

This repository solve flippo problems. See
the [blog post](http://fifth-postulate.nl/blog/2016-12-10.4-Number-Game.html)
for more information. 

Origin
------

From the [wikipedia page][flippo] on flippo's

> are typically flat circular cardboard discs which are decorated with
> images on one or both sides.

One type of flippo was the [*24*][24-game]. It listed four numbers and
one had to make 24 by combining the listed numbers and the standard
arithmetic operators _+_, _-_, _*_, _/_.

Solution
--------

Every aritmitical expression can be seen as a tree. For example the
expression `3 * (1 + 2)` corresponds with the following tree

```
 *
/ \
3  +
  / \
 1   2
```

We are going to attack the problem along the following lines.

1. Generate all tree structures.
2. Foreach tree structure assign values to the leafs and operations to
   the internal nodes.
3. Evaluate each tree and check with the target number.

[flippo]: http://en.wikipedia.org/wiki/Pogs
[24-game]: https://www.24game.com/
