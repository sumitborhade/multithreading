# Deadlocks in Java

**Situation:**
Deadlock occurs when Thread-A holds lock 1 and waits for lock 2.
At the same time, Thread-B holds lock 2 and waits for lock 1.


**Detection:**
1. For windows, go to task bar and find the process id of the program 
2. For unix, ps -ef | grep {process description} or lsof -i:{port} to get the pid
3. {JAVA_HOME}\bin\jstack {pid}
4. Console will print the details 


**Solution:**
Ordering of the locks is important.