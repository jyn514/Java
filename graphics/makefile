all: swing/Minesweeper/Gui.class javafx/HelloWorld.class

swing/Minesweeper/Gui.class:
	$(MAKE) -C swing/Minesweeper all

javafx/HelloWorld.class:
	$(MAKE) -C javafx all

clean:
	$(MAKE) -C swing/Minesweeper clean
	$(MAKE) -C javafx clean
