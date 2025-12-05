# BCS502 - ChatGPT

**01. Functions of different layers**

Each layer handles a specific task: physical sends bits, data link frames them, network routes packets, transport ensures reliable/unreliable delivery, session manages communication, presentation formats data, application provides user-level services. 

**02. TCP/IP vs OSI**

OSI has 7 layers; TCP/IP has 4. OSI separates presentation & session; TCP/IP folds them into application. OSI is conceptual; TCP/IP is practical and used in real networks. 

**03. Why header is required?**

Headers carry control info like addresses, sequence numbers, and protocol details so data can be delivered correctly. 

**04. Why add header and trailer?**

Headers guide delivery; trailers usually hold error-checking details (e.g., CRC) to detect corruption. 

**05. Encapsulation**

Wrapping data with protocol-specific headers/trailers while moving down layers. 

**06. Why fragmentation?**

Packets too large for a network’s MTU must be broken into smaller pieces to pass through. 

**07. MTU**

Maximum Transmission Unit — largest frame size a network can carry. 

**08. Which layer imposes MTU?**

Data Link layer. 

**09. Flow vs Congestion control**

Flow control protects the receiver; congestion control protects the network from overload. 

**10. Point-to-Point vs End-to-End**

Point-to-point connects two direct nodes; end-to-end spans entire path between sender and receiver. 

**11. Protocols in layers**

Examples:
Physical—Ethernet PHY;
Data Link—Ethernet, PPP;
Network—IP, ICMP;
Transport—TCP, UDP;
Application—HTTP, FTP, DNS. 

**12. Protocol Stack**

Collection of layered protocols working together (e.g., TCP/IP stack). 

**13. TCP vs UDP**

TCP is reliable, connection-oriented, slower; UDP is unreliable, connectionless, faster. 

**14. Connectionless vs Connection-oriented**

Connectionless sends without setup; connection-oriented establishes a session before data transfer. 

**15. Why frame sorting?**

To reorder frames arriving out of sequence to reconstruct correct data. 

**16. Subnet**

A logically divided part of an IP network. 

**17. Gateway**

A device connecting networks using different protocols. 

**18. IP Address**

Logical address identifying a host over a network. 

**19. MAC Address**

Unique hardware address assigned to a NIC. 

**20. Why IP when MAC exists?**

MACs work only locally; IP enables global routing across networks. 

**21. Port**

A logical endpoint for communication between processes. 

**22. Ephemeral & Well-known ports**

Well-known: 0–1023; Ephemeral: temporary, high-numbered ports used by clients. 

**23. Socket**

Combination of IP + port used for communication. 

**24. Parameters of socket()**

Domain (AF_INET), type (SOCK_STREAM/UDP), protocol. 

**25. bind(), listen(), accept(), connect(), send(), recv()**

bind: assign address; listen: wait for connections; accept: receive client; connect: initiate connection; send/recv: data transfer. 

**26. System calls**

OS-invoked functions like open, read, write, fork, exec. 

**27. IPC**

Inter-process Communication — pipes, message queues, shared memory. 

**28. mkfifo(), open(), close()**

mkfifo: create named pipe; open: access file/pipe; close: release descriptor. 

**29. File descriptor**

Integer identifier for an opened file/pipe/socket. 

**30. Traffic shaping**

Controlling traffic rate to avoid congestion. 

**31. Congestion control classification**

Open-loop (preventive) and closed-loop (reactive). 

**32. Leaky vs Token bucket**

Leaky: fixed output rate; Token bucket: allows bursts if tokens available. 

**33. Implement Leaky bucket**

Queue packets and release them at a constant rate; drop excess. 

**34. Generate bursty traffic**

Send packets faster than the average rate intermittently. 

**35. CRC-CCITT polynomial**

(x^{16} + x^{12} + x^5 + 1). 

**36. Other error detection algorithms**

Parity, checksum, Hamming, Reed-Solomon. 

**37. CRC vs Hamming**

CRC detects errors; Hamming detects and corrects single-bit errors. 

**38. Why Hamming 7,4?**

Uses 7 bits (4 data + 3 parity). 

**39. Odd & Even parity**

Odd ensures odd number of 1s; even ensures even count. 

**40. Syndrome**

Binary pattern indicating error location in decoding. 

**41. Generator matrix**

Matrix used to encode data bits into codewords. 

**42. Spanning tree**

A tree covering all graph nodes with no cycles. 

**43. Prim vs Kruskal**

Prim grows from a node; Kruskal builds by choosing smallest edges globally. 

**44. Routing algorithms**

Algorithms deciding packet paths (e.g., DV, LS). 

**45. Classification of routing algorithms**

Static (manual), Dynamic (DV, LS), Hierarchical. 

**46. Drawbacks of distance vector**

Slow convergence, count-to-infinity, routing loops. 

**47. Router updates distances**

By exchanging routing tables with neighbors. 

**48. Overcoming count-to-infinity**

Split horizon, poison reverse, triggered updates. 

**49. Cryptography**

Securing data through encoding techniques. 

**50. Classification of crypto algorithms**

Symmetric, asymmetric, hashing. 

**51. Public key**

Key shared openly for encryption/verification. 

**52. Private key**

Secret key used for decryption/signing. 

**53. Key, ciphertext, plaintext**

Key: secret used; plaintext: original data; ciphertext: encrypted data. 

**57. Router**

Device forwarding packets between networks. 

**58. Bridge**

Connects and filters traffic between LAN segments. 

**59. Switch**

Multiport bridge operating at data link layer. 

**60. Hub**

Broadcasting device with no intelligence. 

**61. Router vs Bridge vs Switch vs Hub**

Router routes by IP; bridge filters by MAC; switch switches frames per port; hub blindly broadcasts. 

**75. Logical vs Physical address**

Logical = IP; physical = MAC. 

**76. Which address changes when moving?**

Logical (IP). 

**78. Which layer implements security?**

Application layer (protocols like SSL/TLS).  

---

**54. Simulation**

A method to imitate a real network or system using software models to study behavior without real-world deployment. 

**55. Advantages of Simulation**

It reduces cost, saves time, avoids physical setup, allows repeatability, supports large-scale experimentation, and helps evaluate performance before real implementation. 

**56. Simulation vs Emulation**

Simulation imitates system behavior using models. Emulation replicates actual system functions in real time, behaving like the real system. 

**62. Ping & Telnet**

Ping checks reachability using ICMP echo messages. Telnet enables remote login to another machine via terminal access. 

**63. FTP**

A protocol used to transfer files between client and server over a network. 

**64. BER**

Bit Error Rate—ratio of corrupted bits to total transmitted bits. Indicates link quality. 

**65. Congestion Window**

A TCP state variable controlling how much data can be sent before receiving ACKs; grows/shrinks based on congestion. 

**66. BSS**

Basic Service Set—fundamental building block of IEEE 802.11 WLAN consisting of stations communicating in a group. 

**67. Incoming vs Outgoing Throughput**

Incoming: rate of successfully received data. Outgoing: rate of successfully transmitted data. 

**68. Collision**

When two nodes transmit simultaneously on a shared medium causing frame corruption. 

**69. Generating Multiple Traffics**

Create multiple sender-receiver pairs and assign traffic flows (CBR, FTP, etc.) independently to each pair in the simulator. 

**70. Setup Ethernet LAN**

Arrange nodes, connect using Ethernet links, configure LAN switches/interfaces, assign IPs, and define routing/traffic. 

**71. Mobile Host**

A node able to change its point of attachment while maintaining network connectivity. 

**72. NCTUns**

A high-fidelity network simulator/emulator supporting wired, wireless, and mobile networks with GUI-based configuration. 

**73. Dispatcher, Coordinator, NCTUns Client**

Dispatcher starts simulations; Coordinator manages execution; Client provides GUI for configuration and control. 

**74. Other Network Simulators**

ns-2, ns-3, OPNET, OMNeT++, QualNet. 

**77. ICMP & Uses**

Internet Control Message Protocol—used for error reporting and diagnostics (e.g., destination unreachable, echo request/reply, time exceeded). 
