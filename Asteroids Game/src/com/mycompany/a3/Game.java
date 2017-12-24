package com.mycompany.a3;

import com.codename1.ui.*;
import com.codename1.ui.plaf.*;
import com.codename1.charts.util.*;
import com.codename1.ui.layouts.*;
import com.codename1.ui.util.UITimer;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;

public class Game extends Form implements ActionListener, Runnable {
	private GameWorld gw;
	private MapView mv;
	private PointsView pv;
	private static int mapWidth;
	private static int mapHeight;
	private UITimer timer;
	private boolean paused;
	
	private AddAsteroidCommand addAsteroid = AddAsteroidCommand.getInstance();
	private AddShipCommand addShip = AddShipCommand.getInstance();
	private AddStationCommand addStation = AddStationCommand.getInstance();
	private DecreaseCommand decrease = DecreaseCommand.getInstance();
	private IncreaseCommand increase = IncreaseCommand.getInstance();
	private JumpCommand jump = JumpCommand.getInstance();
	private FireCommand fire = FireCommand.getInstance();
	private QuitCommand quit = QuitCommand.getInstance();
	private LeftCommand left = LeftCommand.getInstance();
	private RightCommand right = RightCommand.getInstance();
	private AboutCommand about = AboutCommand.getInstance();
	private SoundCheckCommand sound = SoundCheckCommand.getInstance();
	private PrintDisplayCommand print = PrintDisplayCommand.getInstance();
	private PauseCommand pause = PauseCommand.getInstance();
	private RefuelCommand refuel = RefuelCommand.getInstance();
	private CrashShipCommand crash = CrashShipCommand.getInstance();
	
	private Button addAsteroidButton;
	private Button addShipButton;
	private Button addStationButton;
	private Button increaseButton;
	private Button decreaseButton;
	private Button leftButton;
	private Button rightButton;
	private Button jumpButton;
	private Button fireButton;
	private Button printDisplayButton;
	private Button pauseButton;
	private Button aboutButton;
	private Button quitButton;
	private Button refuelButton;
	private Button crashButton;
	
	public Game() {
		this.setLayout(new BorderLayout());
		
		mv = new MapView();
		pv = new PointsView();
		
		Container northContainer = new Container();
		northContainer.setLayout(new FlowLayout());
		northContainer = FlowLayout.encloseCenter(pv);
		this.add(BorderLayout.NORTH, northContainer);
		
		Container westContainer = new Container();
		westContainer.setLayout(new FlowLayout());
		
		addAsteroidButton = new Button ("Add Asteroid (a)");
		addShipButton = new Button ("Add Ship (s)");
		addStationButton = new Button ("Add Station (b)");
		increaseButton = new Button ("Increase Speed (i)");
		decreaseButton = new Button ("Decrease Speed (d)");
		leftButton = new Button ("Turn Left (l)");
		rightButton = new Button ("Turn Right (r)");
		jumpButton = new Button ("Hyperspace (j)");
		fireButton = new Button ("Fire Missile (f)");
//		Button refillMissileButton = new Button ("Refill Missiles (n)");
//		Button crashShipButton = new Button ("Crash Ship (c)");
//		Button killAsteroidButton = new Button ("Kill Asteroid (k)");
//		Button exterminateButton = new Button ("Exterminate (x)");
//		Button tickButton = new Button ("Tick (t)");
		printDisplayButton = new Button ("Print Display (m)");
		pauseButton = new Button ("Pause Game (p)");
		aboutButton = new Button ("About (!)");
		quitButton = new Button ("Quit (q)");
		refuelButton = new Button ("Refuel (R)");
		crashButton = new Button ("Crash Ship (c)");
		
		addAsteroidButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 0, 255));
		addAsteroidButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		addShipButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 0, 255));
		addShipButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		addStationButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 0, 255));
		addStationButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		increaseButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 0, 255));
		increaseButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		decreaseButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 0, 255));
		decreaseButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		leftButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 0, 255));
		leftButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		rightButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 0, 255));
		rightButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		jumpButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 0, 255));
		jumpButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		fireButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 0, 255));
		fireButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
//		refillMissileButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 0, 255));
//		refillMissileButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
//		crashShipButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 0, 255));
//		crashShipButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
//		killAsteroidButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 0, 255));
//		killAsteroidButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
//		exterminateButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 0, 255));
//		exterminateButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
//		tickButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 0, 255));
//		tickButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		pauseButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 0, 255));
		pauseButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		quitButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 0, 255));
		quitButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		printDisplayButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 0, 255));
		printDisplayButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		aboutButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 0, 255));
		aboutButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		refuelButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 0, 255));
		refuelButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		crashButton.getUnselectedStyle().setBgColor(ColorUtil.rgb(0, 0, 255));
		crashButton.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		
		addAsteroidButton.getAllStyles().setPadding(TOP, 10);
		addAsteroidButton.getAllStyles().setPadding(BOTTOM, 10);
		addShipButton.getAllStyles().setPadding(TOP, 10);
		addShipButton.getAllStyles().setPadding(BOTTOM, 10);
		addStationButton.getAllStyles().setPadding(TOP, 10);
		addStationButton.getAllStyles().setPadding(BOTTOM, 10);
		increaseButton.getAllStyles().setPadding(TOP, 10);
		increaseButton.getAllStyles().setPadding(BOTTOM, 10);
		decreaseButton.getAllStyles().setPadding(TOP, 10);
		decreaseButton.getAllStyles().setPadding(BOTTOM, 10);
		leftButton.getAllStyles().setPadding(TOP, 10);
		leftButton.getAllStyles().setPadding(BOTTOM, 10);
		rightButton.getAllStyles().setPadding(TOP, 10);
		rightButton.getAllStyles().setPadding(BOTTOM, 10);
		jumpButton.getAllStyles().setPadding(TOP, 10);
		jumpButton.getAllStyles().setPadding(BOTTOM, 10);
		fireButton.getAllStyles().setPadding(TOP, 10);
		fireButton.getAllStyles().setPadding(BOTTOM, 10);
//		refillMissileButton.getAllStyles().setPadding(TOP, 10);
//		refillMissileButton.getAllStyles().setPadding(BOTTOM, 10);
//		crashShipButton.getAllStyles().setPadding(TOP, 10);
//		crashShipButton.getAllStyles().setPadding(BOTTOM, 10);
//		killAsteroidButton.getAllStyles().setPadding(TOP, 10);
//		killAsteroidButton.getAllStyles().setPadding(BOTTOM, 10);
//		exterminateButton.getAllStyles().setPadding(TOP, 10);
//		exterminateButton.getAllStyles().setPadding(BOTTOM, 10);
//		tickButton.getAllStyles().setPadding(TOP, 10);
//		tickButton.getAllStyles().setPadding(BOTTOM, 10);
		pauseButton.getAllStyles().setPadding(TOP, 10);
		pauseButton.getAllStyles().setPadding(BOTTOM, 10);
		quitButton.getAllStyles().setPadding(TOP, 10);
		quitButton.getAllStyles().setPadding(BOTTOM, 10);
		printDisplayButton.getAllStyles().setPadding(TOP, 10);
		printDisplayButton.getAllStyles().setPadding(BOTTOM, 10);
		aboutButton.getAllStyles().setPadding(TOP, 10);
		aboutButton.getAllStyles().setPadding(BOTTOM, 10);
		refuelButton.getAllStyles().setPadding(TOP, 10);
		refuelButton.getAllStyles().setPadding(BOTTOM, 10);
		crashButton.getAllStyles().setPadding(TOP, 10);
		crashButton.getAllStyles().setPadding(BOTTOM, 10);
		
		Container tempCWest = new Container();
		tempCWest.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		tempCWest.add(addAsteroidButton);
		tempCWest.add(addStationButton);
		tempCWest.add(addShipButton);
		tempCWest.add(increaseButton);
		tempCWest.add(decreaseButton);
		tempCWest.add(leftButton);
		tempCWest.add(rightButton);
		tempCWest.add(jumpButton);
		tempCWest.add(fireButton);
		tempCWest.add(refuelButton);
		tempCWest.add(crashButton);
//		tempCWest.add(refillMissileButton);
//		tempCWest.add(crashShipButton);
//		tempCWest.add(killAsteroidButton);
//		tempCWest.add(exterminateButton);
//		tempCWest.add(tickButton);
//		tempCWest.add(pauseButton);
//		tempCWest.add(printDisplayButton);
//		tempCWest.add(quitButton);
//		tempCWest.add(aboutButton);
		
		
		
		westContainer = FlowLayout.encloseCenterMiddle(tempCWest);
		westContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.rgb(0, 0, 0)));
		this.add(BorderLayout.WEST, westContainer);
		
		Container southContainer = new Container();
		southContainer.setLayout(new FlowLayout());
		
		southContainer.add(pauseButton);
		southContainer.add(printDisplayButton);
		southContainer.add(quitButton);
		southContainer.add(aboutButton);
		
		//add an “empty” item to overflow menu
		Command newOption = new Command("New");
		Command saveOption = new Command("Save");
		Command undoOption = new Command("Undo");
		Command soundOption = new Command("Sound");
		Command aboutOption = new Command("About");
		Command quitOption = new Command("Quit");
		
		southContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.rgb(0, 0, 0)));
		this.add(BorderLayout.SOUTH, southContainer);
		
		Container centerContainer = new Container();
		centerContainer.setLayout(new BorderLayout());
		centerContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.rgb(255, 255, 7)));
//		centerContainer.add(mv);
		this.add(BorderLayout.CENTER, mv);
//		centerContainer.add(mv);

//		this.add(BorderLayout.CENTER, mv);
		mv.setGame(this);
		gw = new GameWorld();
		gw.addObserver(mv);
		gw.addObserver(pv);
		gw.updateWorld();
		
		AddAsteroidCommand.setTarget(gw);
//		addAsteroid = new AddAsteroidCommand(gw); 
		AddStationCommand.setTarget(gw);
		AddShipCommand.setTarget(gw);
		IncreaseCommand.setTarget(gw);
		DecreaseCommand.setTarget(gw);
		LeftCommand.setTarget(gw);
		RightCommand.setTarget(gw);
		FireCommand.setTarget(gw);
		JumpCommand.setTarget(gw);
//		LoadMissilesCommand loadMissiles = new LoadMissilesCommand(gw);
//		KillAsteroidCommand killAsteroid = new KillAsteroidCommand(gw);
//		CrashShipCommand crashShip = new CrashShipCommand(gw);
//		ExterminateCommand exterminate = new ExterminateCommand(gw);
		SoundCheckCommand.setTarget(gw);
		PauseCommand.setTarget(this);
//		TickCommand tick = new TickCommand(gw);
		QuitCommand.setTarget(gw);
		PrintDisplayCommand.setTarget(gw);
		AboutCommand.setTarget(gw);
		RefuelCommand.setTarget(gw);
		CrashShipCommand.setTarget(gw);
		
		addAsteroidButton.setCommand(AddAsteroidCommand.getInstance());
		addStationButton.setCommand(addStation);
		addShipButton.setCommand(addShip);
		increaseButton.setCommand(increase);
		decreaseButton.setCommand(decrease);
		leftButton.setCommand(left);
		rightButton.setCommand(right);
		fireButton.setCommand(fire);
		jumpButton.setCommand(jump);
//		refillMissileButton.setCommand(loadMissiles);
//		killAsteroidButton.setCommand(killAsteroid);
//		crashShipButton.setCommand(crashShip);
//		exterminateButton.setCommand(exterminate);
//		tickButton.setCommand(tick);
		quitButton.setCommand(quit);
		pauseButton.setCommand(pause);
		printDisplayButton.setCommand(print);
		aboutButton.setCommand(about);
		refuelButton.setCommand(refuel);
		crashButton.setCommand(crash);
		
		//Key Bindings
		addKeyListener('a', addAsteroid);
		addKeyListener('b', addStation);
		addKeyListener('s', addShip);
		addKeyListener('i', increase);
		addKeyListener('d', decrease);
		addKeyListener('l', left);
		addKeyListener('r', right);
		addKeyListener('f', fire);
		addKeyListener('j', jump);
//		addKeyListener('n', loadMissiles);
//		addKeyListener('k', killAsteroid);
//		addKeyListener('c', crashShip);
//		addKeyListener('x', exterminate);
//		addKeyListener('t', tick);
		addKeyListener('Q', quit);
		addKeyListener('p', pause);
		addKeyListener('A', about);
		addKeyListener('m', print);
		addKeyListener('c', crash);
		
		Toolbar tb = new Toolbar();
		setToolbar(tb);
		tb.setTitle("Asteroid Game");
		tb.setTitleCentered(true);
		
		CheckBox soundCheck = new CheckBox("Turn Sound ON / OFF");
		soundCheck.getAllStyles().setBgTransparency(255);
		soundCheck.getAllStyles().setBgColor(ColorUtil.rgb(150, 150, 150));
		soundCheck.setCommand(sound);
		sound.putClientProperty("SideComponent", soundCheck);
		soundCheck.setText("Turn Sound ON / OFF");
		tb.addComponentToSideMenu(soundCheck);
		
		tb.addCommandToOverflowMenu(newOption);
		tb.addCommandToOverflowMenu(saveOption);
		tb.addCommandToOverflowMenu(undoOption);
		tb.addCommandToOverflowMenu(soundOption);
		tb.addCommandToOverflowMenu(aboutOption);
		tb.addCommandToOverflowMenu(quitOption);
		
		timer = new UITimer(this);
		timer.schedule(30, true, this);
		
		this.requestFocus();
		this.show();
		
		mapWidth = mv.getWidth();
		mapHeight = mv.getHeight();
		
		gw.setMapWidth(mapWidth);
		gw.setMapHeight(mapHeight);
		
		refuelButton.setEnabled(false);

		gw.updateWorld();
		
		System.out.println("Width: " + mapWidth);
		System.out.println("Height: " + mapHeight);
		
		System.out.println("Game created\n");
	}
	
	public static int getMapWidth() {
		return mapWidth;
	}
	
	public static int getMapHeight() {
		return mapHeight;
	}
	
	public boolean isPaused() {
		return paused;
	}
	
	public void pauseGame() {
		
		timer.cancel(); 
 		paused = true; 
 		System.out.println("Game paused");
 		gw.setSoundOff();
 		
 		removeKeyListener('a', addAsteroid);
 		removeKeyListener('b', addStation);
		removeKeyListener('s', addShip);
		removeKeyListener('i', increase);
		removeKeyListener('d', decrease);
		removeKeyListener('l', left);
		removeKeyListener('r', right);
		removeKeyListener('f', fire);
		removeKeyListener('j', jump);
		removeKeyListener('c', crash);
		addKeyListener('R', refuel);
		
 		addAsteroidButton.setEnabled(false); 
 		addShipButton.setEnabled(false); 
 		addStationButton.setEnabled(false);
 		fireButton.setEnabled(false);
 		leftButton.setEnabled(false); 
 		rightButton.setEnabled(false); 
 		increaseButton.setEnabled(false); 
 		decreaseButton.setEnabled(false);
 		jumpButton.setEnabled(false);
 		refuelButton.setEnabled(true);
 		crashButton.setEnabled(false);
 		
 		addAsteroid.setEnabled(false); 
 		addShip.setEnabled(false); 
 		addStation.setEnabled(false); 
 		fire.setEnabled(false);
 		left.setEnabled(false); 
 		right.setEnabled(false); 
 		increase.setEnabled(false); 
 		decrease.setEnabled(false);
 		jump.setEnabled(false);
	}
	
	public void resumeGame() {
		timer.schedule(30, true, this); 
 		paused = false; 
 		System.out.println("Resume game");
 		gw.setSoundOn();
 		
 		addKeyListener('a', addAsteroid);
		addKeyListener('b', addStation);
		addKeyListener('s', addShip);
		addKeyListener('i', increase);
		addKeyListener('d', decrease);
		addKeyListener('l', left);
		addKeyListener('r', right);
		addKeyListener('f', fire);
		addKeyListener('j', jump);
		removeKeyListener('R', refuel);
		addKeyListener('c', crash);
		
		addAsteroidButton.setEnabled(true); 
 		addShipButton.setEnabled(true); 
 		addStationButton.setEnabled(true); 
 		fireButton.setEnabled(true);
 		leftButton.setEnabled(true); 
 		rightButton.setEnabled(true); 
 		increaseButton.setEnabled(true); 
 		decreaseButton.setEnabled(true);
 		jumpButton.setEnabled(true);
 		refuelButton.setEnabled(false);
 		crashButton.setEnabled(true);
 		
 		addAsteroid.setEnabled(true); 
 		addShip.setEnabled(true); 
 		addStation.setEnabled(true); 
 		fire.setEnabled(true);
 		left.setEnabled(true); 
 		right.setEnabled(true); 
 		increase.setEnabled(true); 
 		decrease.setEnabled(true);
 		jump.setEnabled(true);
 		refuel.setEnabled(false);
 		crash.setEnabled(true);
	}
	
//	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.tick();
	}
	
	public void run() {
		gw.tick();
	}
}