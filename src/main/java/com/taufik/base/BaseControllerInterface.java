package com.taufik.base;

import org.springframework.ui.Model;

public interface BaseControllerInterface<T> {
	public String index(Model model);
	public String edit(int id,Model model);
	public String delete(int id,Model model);
	public String add(Model model);
}
