# Kata19 Word Chains by Korga Mateusz
A program that finds connection between two words given from dictionary.
Program returns the shortest possible chain between given words (if connection exists). Words are placed in graph-based structure. 
For finding connection I used breadth first search algorithm with additional HashMap to track path.
<br/>
####MANUAL SERVICE 
Run 'WordChains.java', then:
* enter 'check' to find the shortest chain, then enter two words. They can not be the same. Must be same length.
* enter 'exit' to shut down app

If program finds connection in graph, returns shortest possible path, from first to last and shows operation time in mili seconds.
####Example run:
>Type name of option:
><br/>CHECK
><br/>EXIT
><br/>*check*
><br/>Type source word:
><br/>*dog*
><br/>Type destination word:
><br/>*cat*
><br/>Search took : 3.0 ms
><br/>[dog, dot, dat, cat]


![Alt text](screenshot.jpg?raw=true "screenshot")
*screenshot*
