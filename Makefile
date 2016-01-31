# Makefile
# It has the commands necessary to remove and recompile the classes
# "make all" compiles the program and creates an executable, "cyoa"
# "make test" runs the program after it is compiled
# "make clean" deletes all the classes created
# "make spotless" deletes all the classes created and the executable
JAVASRC    = cyoa.java LinkedList.java
SOURCES    = ${JAVASRC} Makefile README demo.adventure design.pdf
MAINCLASS  = cyoa
JARCLASSES = ${CLASSES}
JARFILE    = cyoa
TESTCLASS  = demo.adventure
CLASSES    = ${patsubst %.java, %.class, ${JAVASRC}}

all : ${JARFILE}

${JARFILE} : ${CLASSES}
	echo "Main-class: ${MAINCLASS}" >Manifest
	jar cvfm ${JARFILE} Manifest ${JARCLASSES}
	rm Manifest
	chmod +x ${JARFILE}
	java cyoa demo.adventure

%.class: %.java
	javac -Xlint $<

test:
	java cyoa demo.adventure

clean :
	rm -f *.class Manifest

spotless : clean
	rm -f ${JARFILE}

.PHONY:all test clean spotless submit
