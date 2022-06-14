package com.itwang.principles.demo3.before;

import com.itwang.principles.demo3.after.*;
import com.itwang.principles.demo3.after.Computer;
import com.itwang.principles.demo3.after.IntelCpu;
import com.itwang.principles.demo3.after.KingstonMemory;
import com.itwang.principles.demo3.after.XiJieHardDisk;

import javax.swing.*;

// 测试类
public class ComputerTest {

    public static void main(String[] args) {

        //创建计算机组件对象
        HardDisk hardDisk = new XiJieHardDisk();
        Cpu cpu = new IntelCpu();
        Memory memory = new KingstonMemory();

        //创建计算机对象
        Computer computer = new Computer();

        //组装计算机
        computer.setHardDisk(hardDisk);
        computer.setCpu(cpu);
        computer.setMemory(memory);

        //开机
        computer.run();
    }
}
