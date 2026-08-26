package pattern.computer;

public class ComputerDemo {
    CPU cpu = new CPU();
    Memory memory = new Memory();
    HardDrive hardDrive = new HardDrive();

    ComputerFacade computer = new ComputerFacade(cpu, memory, hardDrive);
    computer.start();
}
