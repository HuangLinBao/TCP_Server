# TCP_Server
is the Server side for the TCP part in my [Networks HW](https://github.com/HuangLinBao/peer2peerHW). I've explained most of the functionality there and I'll just
explain the functionality of the server here.

## How does it work
Simply when a sentence arrives "weather was a message to be sent or credentials for login" it goes to either the [RedirectThread](https://github.com/HuangLinBao/TCP_Server/blob/master/src/main/java/io/github/HuangLinBao/RedirectThread.java) or the [ServerThread](https://github.com/HuangLinBao/TCP_Server/blob/master/src/main/java/io/github/HuangLinBao/ServerThread.java)
respectively.
How?. to tell the differance between the message and the credantials I wraped the message to be a CSV[Comma Separated Value and the credentials to be hyphenated.
each Thread sees if the arriving sentance fit and does the operation needed if true.


## Problems
There is a problem with the TCP part of the HW which is the long time to wait untill a message is received and redirected weather the process was the Login to fetch
online users or the message redirection, it's either a really long wait or a Connection timedout exception.
