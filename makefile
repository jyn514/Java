DIRS != find -mindepth 1 -maxdepth 1 -type d | tr ' ' '\n' | grep -v '.git'

all:
	for dir in $(DIRS); do \
		$(MAKE) -C $$dir all; \
	done

clean:
	for dir in $$(ls --quoting-style=shell-escape); do \
		$(MAKE) -C $$dir clean; \
	done

.PHONY: clean all
