# BCS502 Viva - Google Gemini

**01. What are functions of different layers?**

The OSI model layers function as follows:
* **Physical:** Transmits raw bits over a medium.
* **Data Link:** Handles framing and physical addressing (MAC).
* **Network:** Manages routing and logical addressing (IP).
* **Transport:** Ensures end-to-end delivery and reliability (TCP/UDP).
* **Session:** Manages sessions between applications.
* **Presentation:** Translates data formats (encryption, compression).
* **Application:** Provides network services to user applications.

**02. Differentiate between TCP/IP Layers and OSI Layers.**

The **OSI model** is a theoretical reference model with 7 specific layers, focusing on strict modularity. The **TCP/IP model** is a practical implementation protocol suite with 4 (or 5) layers. TCP/IP combines OSI's Session, Presentation, and Application layers into a single Application layer and generally combines Data Link and Physical into a Network Access layer.

**03. Why header is required?**

A header is required to carry **control information** necessary for the protocol to function. This includes source and destination addresses, sequence numbers, error detection codes, and protocol identification, ensuring data reaches the correct destination and is processed correctly.

**04. What is the use of adding header and trailer to frames?**

Headers provide addressing and control information (start of frame), while trailers typically contain **Error Detection** data (like CRC). Together, they define the boundaries of the frame (framing) and ensure data integrity during transmission.

**05. What is encapsulation?**

Encapsulation is the process of wrapping data from a higher layer with protocol information (headers/footers) of the current layer. For example, a Transport segment is encapsulated in a Network packet, which is then encapsulated in a Data Link frame.

**06. Why fragmentation requires?**

Fragmentation is required when the size of an IP packet exceeds the **Maximum Transmission Unit (MTU)** of the underlying network link. The router breaks the packet into smaller fragments to fit through the link.

**07. What is MTU?**

MTU stands for **Maximum Transmission Unit**. It is the largest size (in bytes) of a data packet or frame that a specific network layer or interface can transmit without fragmentation.

**08. Which layer imposes MTU?**

The **Data Link Layer** (Layer 2) imposes the MTU. Different physical network technologies (like Ethernet vs. Token Ring) have different physical constraints on frame size.

**09. Differentiate between flow control and congestion control.**

* **Flow Control:** Prevents a fast sender from overwhelming a slow **receiver** (Point-to-Point).
* **Congestion Control:** Prevents the sender from overwhelming the **network** infrastructure (routers/switches) to avoid traffic collapse.

**10. Differentiate between Point-to-Point Connection and End-to-End connections.**

* **Point-to-Point:** Communication between two directly connected nodes (e.g., between two routers or a computer and a switch). Handled by the Data Link layer.
* **End-to-End:** Communication between the original source and the final destination, regardless of the number of intermediate nodes. Handled by the Transport layer.

**11. What are protocols running in different layers?**

* **Application:** HTTP, FTP, SMTP, DNS.
* **Transport:** TCP, UDP.
* **Network:** IP, ICMP, ARP.
* **Data Link:** Ethernet, Wi-Fi (802.11).

**12. What is Protocol Stack?**

A protocol stack is a set of network protocol layers that work together to provide networking capabilities. It is the software implementation of a networking model (like TCP/IP), where lower layers serve the higher layers.

**13. Differentiate between TCP and UDP.**

* **TCP (Transmission Control Protocol):** Connection-oriented, reliable, guarantees delivery and order, heavyweight (uses handshakes). Used for web, email.
* **UDP (User Datagram Protocol):** Connectionless, unreliable, no guarantee of delivery or order, lightweight and fast. Used for streaming, VoIP, gaming.

**14. Differentiate between Connectionless and connection oriented connection.**

* **Connection-oriented:** Requires a setup phase (handshake) before data transfer and a teardown phase (e.g., phone call, TCP). Guarantees reliability.
* **Connectionless:** Data is sent without prior setup (e.g., postal mail, UDP). Packets may take different routes and arrive out of order.

**15. Why frame sorting is required?**

Frame sorting is required in connectionless or packet-switched networks because packets (frames) may travel different routes and arrive at the destination **out of order**. The receiver must sort them using sequence numbers to reconstruct the original message.

**16. What is meant by subnet?**

A subnet (subnetwork) is a logical subdivision of an IP network. It allows a large network to be split into smaller, manageable pieces to improve performance and security.

**17. What is meant by Gateway?**

A Gateway is a network node that acts as an entrance to another network. It often translates between different network protocols or connects different network segments (e.g., a home router acting as a gateway between a LAN and the Internet).

**18. What is an IP address?**

An IP (Internet Protocol) address is a unique **logical** numerical identifier assigned to each device on a network using the Internet Protocol. It allows for routing data across different networks (e.g., `192.168.1.1`).

**19. What is MAC address?**

A MAC (Media Access Control) address is a unique **physical** identifier burned into the network interface card (NIC) by the manufacturer. It is used for local communication within a network segment (Layer 2).

**20. Why IP address is required when we have MAC address?**

MAC addresses are flat and physical, useful only for local delivery. IP addresses are hierarchical and logical, allowing **routing** across the global internet. You need IP to find the network, and MAC to find the specific device once you arrive at that network.

**21. What is meant by port?**

A port is a logical endpoint that identifies a specific process or service running on a computer. It ensures that data reaching a computer is delivered to the correct application (e.g., Web server on port 80).

**22. What are ephemerical port number and well known port numbers?**

* **Well-known ports (0-1023):** Reserved for standard services (e.g., HTTP=80, SSH=22).
* **Ephemeral ports (1024-65535):** Temporary ports assigned automatically by the OS to client applications for short-term communications.

**23. What is a socket?**

A socket is an endpoint for communication between two machines. It is defined by an IP address and a Port number, allowing an application to read from or write to the network.

**24. What are the parameters of socket()?**

The standard C syntax is `socket(domain, type, protocol)`.
* **Domain:** Address family (e.g., `AF_INET` for IPv4).
* **Type:** Socket type (e.g., `SOCK_STREAM` for TCP, `SOCK_DGRAM` for UDP).
* **Protocol:** Specific protocol (usually 0 to select default).

**25. Describe bind(), listen(), accept(), connect(), send() and recv().**

* **bind():** Associates a socket with a local IP and port.
* **listen():** Puts the socket in a passive mode to wait for incoming connections.
* **accept():** Extracts the first connection request and creates a new connected socket.
* **connect():** Initiates a connection to a remote socket (client-side).
* **send()/recv():** Functions to write data to and read data from a connected socket.

**26. What are system calls? Mention few of them.**

System calls are programmatic requests a computer program makes to the operating system kernel for services. Examples include `open()`, `read()`, `write()`, `close()`, and `fork()`.

**27. What is IPC? Name three techniques.**

IPC (Inter-Process Communication) refers to mechanisms allowing processes to manage shared data or synchronize actions. Techniques include:
1.  **Pipes** (or Named Pipes/FIFOs)
2.  **Shared Memory**
3.  **Message Queues** (or Sockets)

**28. Explain mkfifo(), open(), close() with parameters.**

* `mkfifo(path, mode)`: Creates a named pipe (FIFO) at `path` with permission `mode`.
* `open(path, flags)`: Opens a file or device at `path`; `flags` determine access mode (e.g., Read Only).
* `close(fd)`: Closes the file descriptor `fd`, releasing the resource.

**29. What is meant by file descriptor?**

A file descriptor is a non-negative integer serving as an abstract indicator (handle) used to access a file or other input/output resource, such as a pipe or network socket.

**30. What is meant by traffic shaping?**

Traffic shaping is a mechanism to control the volume and rate of traffic sent into a network. It buffers excess packets and releases them at a steady rate to adhere to a desired traffic profile.

**31. How do you classify congestion control algorithms?**

They are classified into:
* **Open Loop:** Prevention policies designed to stop congestion before it happens (e.g., retransmission policy, window policy).
* **Closed Loop:** Mechanisms that remove congestion after it is detected (e.g., choke packets, implicit/explicit signaling).

**32. Differentiate between Leaky bucket and Token bucket.**

* **Leaky Bucket:** Smoothes bursty traffic into a constant rate. If the bucket overflows, packets are discarded. Output is fixed.
* **Token Bucket:** Allows for bursty traffic up to a limit. Tokens accumulate; to send a packet, a token must be consumed. Output rate can vary.

**33. How do you implement Leaky bucket?**

It is implemented using a FIFO queue. Incoming packets enter the queue. A processor removes packets from the queue at a constant, fixed time interval (e.g., one packet per tick) regardless of the arrival rate. If the queue is full, incoming packets are dropped.

**34. How do you generate bursty traffic?**

Bursty traffic is generated by sending data in uneven patterns—large amounts of data in very short periods followed by periods of inactivity. This simulates real-world scenarios like web browsing or video streaming.

**35. What is the polynomial used in CRC-CCITT?**

The generator polynomial for CRC-CCITT is $x^{16} + x^{12} + x^5 + 1$. It is a 16-bit CRC widely used in communications.

**36. What are the other error detection algorithms?**

Aside from CRC, others include:
* **Parity Check** (Simple/2D)
* **Checksum** (used in IP/TCP headers)
* **Hamming Code** (typically for error correction, but detects errors too).

**37. What is difference between CRC and Hamming code?**

**CRC** (Cyclic Redundancy Check) is designed primarily for **error detection** and is very robust against burst errors. **Hamming code** is designed for **error correction** (specifically single-bit errors) as well as detection.

**38. Why Hamming code is called 7,4 code?**

It is called (7,4) because the code word length is **7 bits** total, which includes **4 data bits** and **3 parity (redundant) bits**.

**39. What is odd parity and even parity?**

* **Even Parity:** A bit is added to ensure the total number of 1s in the data is even.
* **Odd Parity:** A bit is added to ensure the total number of 1s in the data is odd.

**40. What is meant by syndrome?**

In error correction (like Hamming codes), the **syndrome** is the result of a calculation performed by the receiver on the received data. If the syndrome is all zeros, there is no error; if non-zero, it indicates the position of the error.

**41. What is generator matrix?**

In linear block codes (like Hamming), the generator matrix is a matrix used to encode the data. Multiplying the data vector by the generator matrix produces the codeword.

**42. What is spanning tree?**

A spanning tree is a subset of a graph that includes all vertices with the minimum number of edges required to connect them, containing no cycles (loops). In networking (STP), it prevents loops in bridge/switch topologies.

**43. Differentiate between Prim's and Kruskal's algorithm.**

Both find the Minimum Spanning Tree (MST).
* **Prim’s:** Starts from one node and grows the tree by adding the nearest connected node.
* **Kruskal’s:** Sorts all edges by weight and adds the smallest edge that doesn't form a cycle, regardless of connection to a specific starting node.

**44. What are Routing algorithms?**

Routing algorithms are software protocols that determine the optimal path for a data packet to travel from source to destination across a network (e.g., Dijkstra's, Bellman-Ford).

**45. How do you classify routing algorithms?**

* **Static (Non-adaptive):** Routes are manually configured and do not change.
* **Dynamic (Adaptive):** Routes change automatically based on topology or traffic (e.g., Distance Vector, Link State).
* **Intra-domain vs Inter-domain:** Within an AS (OSPF) vs between AS (BGP).

**(Note on "Give examples for each"):**

* Static: Manual routing tables.
* Dynamic: RIP (Distance Vector), OSPF (Link State).

**46. What are drawbacks in distance vector algorithm?**

The main drawback is the **Count-to-Infinity problem**, where bad news (link failure) propagates slowly, causing routing loops. It also has slow convergence and high bandwidth usage for periodic updates.

**47. How routers update distances to each of its neighbor?**

In Distance Vector routing, routers periodically broadcast their entire routing table to their immediate neighbors. Neighbors calculate new distances by adding the cost of the link to the neighbor to the distance reported by that neighbor.

**48. How do you overcome count to infinity problem?**

Techniques include:
* **Split Horizon:** Don't send route info back to the neighbor you learned it from.
* **Poison Reverse:** Send a distance of infinity back to the source.
* **Hold-down Timers:** Wait before accepting updates after a link goes down.

**49. What is cryptography?**

Cryptography is the practice of securing communication by converting data into unreadable formats (encryption) so that only authorized parties can read it (decryption).

**50. How do you classify cryptographic algorithms?**

* **Symmetric Key:** Sender and receiver use the same key (e.g., AES, DES).
* **Asymmetric (Public) Key:** Uses a pair of keys—public for encryption, private for decryption (e.g., RSA).

**51. What is public key?**

A public key is the part of an asymmetric key pair that is shared openly with everyone. It is used by others to encrypt messages intended for the key owner.

**52. What is private key?**

A private key is the secret part of an asymmetric key pair known only to the owner. It is used to decrypt messages that were encrypted with the corresponding public key (or to digitally sign data).

**53. What are key, ciphertext and plain text?**

* **Plain text:** Original, readable data.
* **Ciphertext:** The scrambled, unreadable output of encryption.
* **Key:** A string of bits used by the algorithm to transform plain text into ciphertext and vice versa.

**57. What is meant by router?**

A router is a Layer 3 (Network) device that connects different networks together. It forwards data packets based on IP addresses and determines the best path for data to travel.

**58. What is meant by bridge?**

A bridge is a Layer 2 device that connects two network segments (typically LANs). It filters traffic based on MAC addresses to reduce collision domains.

**59. What is meant by switch?**

A switch is a multi-port Layer 2 device (essentially a multi-port bridge) that connects devices within a LAN. It forwards data only to the specific port where the destination MAC address acts, improving efficiency.

**60. What is meant by hub?**

A hub is a Layer 1 (Physical) device that connects multiple devices. It is a "dumb" device that broadcasts incoming data to **all** ports, creating a single collision domain and wasting bandwidth.

**61. Differentiate between router, bridge, switch and hub.**

* **Hub:** Layer 1, broadcasts to all, no intelligence.
* **Switch:** Layer 2, unicasts based on MAC, within a network.
* **Bridge:** Layer 2, connects two segments, software-based (usually).
* **Router:** Layer 3, routes between different networks based on IP.

**75. Differentiate between logical and physical address.**

* **Physical Address (MAC):** 48-bit, burned into hardware, flat, used for local delivery, unchanging.
* **Logical Address (IP):** 32-bit (IPv4) or 128-bit (IPv6), assigned by software/admin, hierarchical, used for global routing, changes based on network location.

**76. Which address gets affected if a system moves from one place to another place?**

The **IP address** (Logical) changes because it depends on the network to which the device is connected. The MAC address remains the same.

**78. Which layer implements security for data?**

Security can be implemented at multiple layers, but traditionally:
* **Presentation Layer:** (OSI model definition) handles encryption.
* **Transport Layer:** (TLS/SSL).
* **Network Layer:** (IPSec).
* **Application Layer:** (PGP, HTTPS).

---

**54. What is simulation?**

Simulation is the imitation of the operation of a real-world process or system over time. In computer networking, it involves using software to model the behavior of a network (nodes, links, protocols) to analyze performance without requiring physical hardware implementation.

**55. What are advantages of simulation?**

* **Cost-effective:** No need to buy expensive hardware.
* **Safety:** Experiments can be run without disrupting live networks.
* **Scalability:** Can test large-scale topologies that are hard to build physically.
* **Repeatability:** Scenarios can be re-run with exact parameters to verify results.

**56. Differentiate between Simulation and Emulation.**

* **Simulation** involves mathematical modeling of a system; it mimics the internal state but does not run the actual system software. It usually runs in virtual time.
* **Emulation** duplicates the functions of one system using a different system, allowing the original software to run on it. It typically aims for real-time execution.

**62. What is ping and telnet?**

* **Ping:** A utility used to test the reachability of a host on an IP network. It measures the round-trip time for messages sent from the originating host to a destination computer using ICMP Echo requests.
* **Telnet:** A network protocol used for interactive communication with a remote computer (remote login). It uses a virtual terminal connection but sends data in plain text (unencrypted).

**63. What is FTP?**

File Transfer Protocol (FTP) is a standard network protocol used to transfer computer files from a server to a client on a computer network. It operates on a client-server architecture and uses separate control and data connections.

**64. What is BER?**

Bit Error Rate (BER) is a key parameter in assessing the quality of digital transmission systems. It is defined as the number of bit errors divided by the total number of transferred bits during a studied time interval.
$$BER = \frac{Number\ of\ errors}{Total\ number\ of\ bits}$$

**65. What is meant by congestion window?**

In TCP (Transmission Control Protocol), the congestion window (`cwnd`) is a state variable that limits the amount of data the sender can transmit into the network before receiving an acknowledgment (ACK). It grows or shrinks dynamically to prevent link saturation.

**66. What is BSS?**

Basic Service Set (BSS) is the fundamental building block of an IEEE 802.11 wireless LAN. It consists of a single Access Point (AP) and all associated wireless stations (clients) communicating with it.

**67. What is incoming throughput and outgoing throughput?**

* **Incoming Throughput:** The rate at which valid data is successfully received by a specific network node or interface from the network.
* **Outgoing Throughput:** The rate at which valid data is successfully transmitted or sent from a specific network node or interface onto the network.

**68. What is collision?**

A collision occurs when two or more devices on the same shared network segment (like an Ethernet bus or wireless channel) attempt to transmit data simultaneously. The signals interfere with each other, destroying the data and requiring retransmission.

**69. How do you generate multiple traffics across different sender-receiver pairs?**

In simulation scripts (like TCL for NS2), you create multiple agent pairs (e.g., TCP or UDP agents) and attach them to different nodes. You then connect specific source agents to specific sink agents and use the simulator scheduler to start them at different or overlapping times (e.g., `$ns at 1.0 "$cbr1 start"`).

**70. How do you setup Ethernet LAN?**

In NS2 using TCL, you use the `make-lan` command. You define a list of nodes and specify the bandwidth, delay, link layer type, interface queue, and MAC protocol.
* *Example:* `$ns make-lan $nodelist $bandwidth $delay LL Queue/DropTail Mac/802_3`

**71. What is meant by mobile host?**

A mobile host is a network node that is not fixed to a physical location. In simulations, these nodes are assigned mobility models (defining speed and trajectory) and must handle handovers as they move between different coverage areas or Access Points.

**72. What is meant by NCTUns?**

NCTUns (National Chiao Tung University Network Simulator) is a high-fidelity network simulator and emulator. Unlike NS2, it directly uses the Linux kernel's TCP/IP protocol stack, allowing researchers to run real-world applications and system-level commands within the simulation.

**73. What are dispatcher, coordinator and nctuns client?**

These are components of the NCTUns architecture:
* **GUI Client:** The interface where users draw topologies and configure settings.
* **Dispatcher:** Manages job submissions and assigns simulation jobs to available simulation servers.
* **Coordinator:** Resides on the simulation server; it controls the simulation engine and manages resources during execution.

**74. Name few other Network simulators.**

* NS-2 (Network Simulator 2)
* NS-3
* OMNeT++
* OPNET (Riverbed Modeler)
* QualNet
* Mininet

**77. What is ICMP?**

The Internet Control Message Protocol (ICMP) is a network layer protocol used by network devices (like routers) to diagnose network communication issues. It is not used for exchanging data but for reporting errors and operational information.

**What are uses of ICMP? Name few.**

* **Reachability Testing:** Used by `ping` to check if a host is active.
* **Path Discovery:** Used by `traceroute` to identify hops to a destination.
* **Error Reporting:** Reporting "Destination Unreachable" or "Time Exceeded" (TTL expiration).
* **Flow Control:** Sending "Source Quench" messages to slow down a sender (though less common now).
