package com.smartaleq.bukkit.dwarfcraft;

import java.util.*;

public enum SkillEffects {
    E10 (10,new double[] { 0.20,0.16,0.12,0.08,0.04,0.00,-0.04,-0.08,-0.12,-0.16,-0.20,-0.24,-0.28,-0.32,-0.36,-0.40,-0.44,-0.48,-0.52,-0.56,-0.60,-0.64,-0.68,-0.72,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75 },5,"itemuse",270,0,new int[]{}),
	E11 (11,new double[] { 0.20,0.16,0.12,0.08,0.04,0.00,-0.04,-0.08,-0.12,-0.16,-0.20,-0.24,-0.28,-0.32,-0.36,-0.40,-0.44,-0.48,-0.52,-0.56,-0.60,-0.64,-0.68,-0.72,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75 },5,"itemuse",274,0,new int[]{}),
	E12 (12,new double[] { 0.20,0.16,0.12,0.08,0.04,0.00,-0.04,-0.08,-0.12,-0.16,-0.20,-0.24,-0.28,-0.32,-0.36,-0.40,-0.44,-0.48,-0.52,-0.56,-0.60,-0.64,-0.68,-0.72,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75 },5,"itemuse",257,0,new int[]{}),
	E13 (13,new double[] { 0.20,0.16,0.12,0.08,0.04,0.00,-0.04,-0.08,-0.12,-0.16,-0.20,-0.24,-0.28,-0.32,-0.36,-0.40,-0.44,-0.48,-0.52,-0.56,-0.60,-0.64,-0.68,-0.72,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75 },5,"itemuse",285,0,new int[]{}),
	E14 (14,new double[] { 0.20,0.16,0.12,0.08,0.04,0.00,-0.04,-0.08,-0.12,-0.16,-0.20,-0.24,-0.28,-0.32,-0.36,-0.40,-0.44,-0.48,-0.52,-0.56,-0.60,-0.64,-0.68,-0.72,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75 },5,"itemuse",278,0,new int[]{}),
	E20 (20,new double[] { 0.20,0.16,0.12,0.08,0.04,0.00,-0.04,-0.08,-0.12,-0.16,-0.20,-0.24,-0.28,-0.32,-0.36,-0.40,-0.44,-0.48,-0.52,-0.56,-0.60,-0.64,-0.68,-0.72,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75 },5,"itemuse",269,0,new int[]{}),
	E21 (21,new double[] { 0.20,0.16,0.12,0.08,0.04,0.00,-0.04,-0.08,-0.12,-0.16,-0.20,-0.24,-0.28,-0.32,-0.36,-0.40,-0.44,-0.48,-0.52,-0.56,-0.60,-0.64,-0.68,-0.72,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75 },5,"itemuse",273,0,new int[]{}),
	E22 (22,new double[] { 0.20,0.16,0.12,0.08,0.04,0.00,-0.04,-0.08,-0.12,-0.16,-0.20,-0.24,-0.28,-0.32,-0.36,-0.40,-0.44,-0.48,-0.52,-0.56,-0.60,-0.64,-0.68,-0.72,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75 },5,"itemuse",256,0,new int[]{}),
	E23 (23,new double[] { 0.20,0.16,0.12,0.08,0.04,0.00,-0.04,-0.08,-0.12,-0.16,-0.20,-0.24,-0.28,-0.32,-0.36,-0.40,-0.44,-0.48,-0.52,-0.56,-0.60,-0.64,-0.68,-0.72,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75 },5,"itemuse",284,0,new int[]{}),
	E24 (24,new double[] { 0.20,0.16,0.12,0.08,0.04,0.00,-0.04,-0.08,-0.12,-0.16,-0.20,-0.24,-0.28,-0.32,-0.36,-0.40,-0.44,-0.48,-0.52,-0.56,-0.60,-0.64,-0.68,-0.72,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75 },5,"itemuse",277,0,new int[]{}),
	E30 (30,new double[] { 0.20,0.16,0.12,0.08,0.04,0.00,-0.04,-0.08,-0.12,-0.16,-0.20,-0.24,-0.28,-0.32,-0.36,-0.40,-0.44,-0.48,-0.52,-0.56,-0.60,-0.64,-0.68,-0.72,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75 },5,"itemuse",271,0,new int[]{}),
	E31 (31,new double[] { 0.20,0.16,0.12,0.08,0.04,0.00,-0.04,-0.08,-0.12,-0.16,-0.20,-0.24,-0.28,-0.32,-0.36,-0.40,-0.44,-0.48,-0.52,-0.56,-0.60,-0.64,-0.68,-0.72,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75 },5,"itemuse",275,0,new int[]{}),
	E32 (32,new double[] { 0.20,0.16,0.12,0.08,0.04,0.00,-0.04,-0.08,-0.12,-0.16,-0.20,-0.24,-0.28,-0.32,-0.36,-0.40,-0.44,-0.48,-0.52,-0.56,-0.60,-0.64,-0.68,-0.72,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75 },5,"itemuse",258,0,new int[]{}),
	E33 (33,new double[] { 0.20,0.16,0.12,0.08,0.04,0.00,-0.04,-0.08,-0.12,-0.16,-0.20,-0.24,-0.28,-0.32,-0.36,-0.40,-0.44,-0.48,-0.52,-0.56,-0.60,-0.64,-0.68,-0.72,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75 },5,"itemuse",286,0,new int[]{}),
	E34 (34,new double[] { 0.20,0.16,0.12,0.08,0.04,0.00,-0.04,-0.08,-0.12,-0.16,-0.20,-0.24,-0.28,-0.32,-0.36,-0.40,-0.44,-0.48,-0.52,-0.56,-0.60,-0.64,-0.68,-0.72,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75 },5,"itemuse",279,0,new int[]{}),
	E40 (40,new double[] { 0.00,-0.04,-0.08,-0.12,-0.16,-0.20,-0.24,-0.28,-0.32,-0.36,-0.40,-0.44,-0.48,-0.52,-0.56,-0.60,-0.64,-0.68,-0.72,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75 },0,"itemuse",290,0,new int[]{290,291,292,293,294}),
	E41 (41,new double[] { 0.00,-0.04,-0.08,-0.12,-0.16,-0.20,-0.24,-0.28,-0.32,-0.36,-0.40,-0.44,-0.48,-0.52,-0.56,-0.60,-0.64,-0.68,-0.72,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75 },0,"itemuse",291,0,new int[]{290,291,292,293,294}),
	E42 (42,new double[] { 0.00,-0.04,-0.08,-0.12,-0.16,-0.20,-0.24,-0.28,-0.32,-0.36,-0.40,-0.44,-0.48,-0.52,-0.56,-0.60,-0.64,-0.68,-0.72,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75 },0,"itemuse",292,0,new int[]{290,291,292,293,294}),
	E43 (43,new double[] { 0.00,-0.04,-0.08,-0.12,-0.16,-0.20,-0.24,-0.28,-0.32,-0.36,-0.40,-0.44,-0.48,-0.52,-0.56,-0.60,-0.64,-0.68,-0.72,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75 },0,"itemuse",294,0,new int[]{290,291,292,293,294}),
	E44 (44,new double[] { 0.00,-0.04,-0.08,-0.12,-0.16,-0.20,-0.24,-0.28,-0.32,-0.36,-0.40,-0.44,-0.48,-0.52,-0.56,-0.60,-0.64,-0.68,-0.72,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75,-0.75 },0,"itemuse",293,0,new int[]{290,291,292,293,294}),
	E45 (45,new double[] { 0.20,0.22,0.24,0.26,0.28,0.30,0.32,0.34,0.36,0.38,0.40,0.42,0.44,0.46,0.48,0.50,0.52,0.54,0.56,0.58,0.60,0.62,0.64,0.66,0.68,0.70,0.72,0.74,0.76,0.78,0.80 },5,"itemuse",290,295,new int[]{290,291,292,293,294}),
	E46 (46,new double[] { 0.20,0.22,0.24,0.26,0.28,0.30,0.32,0.34,0.36,0.38,0.40,0.42,0.44,0.46,0.48,0.50,0.52,0.54,0.56,0.58,0.60,0.62,0.64,0.66,0.68,0.70,0.72,0.74,0.76,0.78,0.80 },5,"itemuse",291,295,new int[]{290,291,292,293,294}),
	E47 (47,new double[] { 0.20,0.22,0.24,0.26,0.28,0.30,0.32,0.34,0.36,0.38,0.40,0.42,0.44,0.46,0.48,0.50,0.52,0.54,0.56,0.58,0.60,0.62,0.64,0.66,0.68,0.70,0.72,0.74,0.76,0.78,0.80 },5,"itemuse",292,295,new int[]{290,291,292,293,294}),
	E48 (48,new double[] { 0.20,0.22,0.24,0.26,0.28,0.30,0.32,0.34,0.36,0.38,0.40,0.42,0.44,0.46,0.48,0.50,0.52,0.54,0.56,0.58,0.60,0.62,0.64,0.66,0.68,0.70,0.72,0.74,0.76,0.78,0.80 },5,"itemuse",294,295,new int[]{290,291,292,293,294}),
	E49 (49,new double[] { 0.20,0.22,0.24,0.26,0.28,0.30,0.32,0.34,0.36,0.38,0.40,0.42,0.44,0.46,0.48,0.50,0.52,0.54,0.56,0.58,0.60,0.62,0.64,0.66,0.68,0.70,0.72,0.74,0.76,0.78,0.80 },5,"itemuse",293,295,new int[]{290,291,292,293,294}),
	E50 (50,new double[] { 1.20,1.16,1.12,1.08,1.04,1.00,0.96,0.92,0.88,0.84,0.80,0.76,0.72,0.68,0.64,0.60,0.56,0.52,0.48,0.44,0.40,0.36,0.32,0.28,0.25,0.25,0.25,0.25,0.25,0.25,0.25 },5,"entityattack",268,0,new int[]{}),
	E51 (51,new double[] { 1.20,1.16,1.12,1.08,1.04,1.00,0.96,0.92,0.88,0.84,0.80,0.76,0.72,0.68,0.64,0.60,0.56,0.52,0.48,0.44,0.40,0.36,0.32,0.28,0.25,0.25,0.25,0.25,0.25,0.25,0.25 },5,"entityattack",272,0,new int[]{}),
	E52 (52,new double[] { 1.20,1.16,1.12,1.08,1.04,1.00,0.96,0.92,0.88,0.84,0.80,0.76,0.72,0.68,0.64,0.60,0.56,0.52,0.48,0.44,0.40,0.36,0.32,0.28,0.25,0.25,0.25,0.25,0.25,0.25,0.25 },5,"entityattack",267,0,new int[]{}),
	E53 (53,new double[] { 1.20,1.16,1.12,1.08,1.04,1.00,0.96,0.92,0.88,0.84,0.80,0.76,0.72,0.68,0.64,0.60,0.56,0.52,0.48,0.44,0.40,0.36,0.32,0.28,0.25,0.25,0.25,0.25,0.25,0.25,0.25 },5,"entityattack",283,0,new int[]{}),
	E54 (54,new double[] { 1.20,1.16,1.12,1.08,1.04,1.00,0.96,0.92,0.88,0.84,0.80,0.76,0.72,0.68,0.64,0.60,0.56,0.52,0.48,0.44,0.40,0.36,0.32,0.28,0.25,0.25,0.25,0.25,0.25,0.25,0.25 },5,"entityattack",276,0,new int[]{}),
	E55 (55,new double[] { 0.75,0.80,0.85,0.90,0.95,1.00,1.05,1.10,1.15,1.20,1.25,1.30,1.35,1.40,1.45,1.50,1.55,1.60,1.65,1.70,1.75,1.80,1.85,1.90,1.95,2.00,2.05,2.10,2.15,2.20,2.25 },5,"entityattack",0,0,new int[]{}),
	E56 (56,new double[] { 0.38,0.40,0.43,0.45,0.48,0.50,0.53,0.55,0.58,0.60,0.63,0.65,0.68,0.70,0.73,0.75,0.78,0.80,0.83,0.85,0.88,0.90,0.93,0.95,0.98,1.00,1.03,1.05,1.08,1.10,1.13 },25,"entityattack",0,0,new int[]{}),
	E80 (80,new double[] { 0.75,0.80,0.85,0.90,0.95,1.00,1.05,1.10,1.15,1.20,1.25,1.30,1.35,1.40,1.45,1.50,1.55,1.60,1.65,1.70,1.75,1.80,1.85,1.90,1.95,2.00,2.00,2.00,2.00,2.00,2.00 },5,"fuelforge",0,0,new int[]{}),
	E110 (110,new double[] { 1.10,1.08,1.06,1.04,1.02,1.00,0.98,0.96,0.94,0.92,0.90,0.88,0.86,0.84,0.82,0.80,0.78,0.76,0.74,0.72,0.70,0.68,0.66,0.64,0.62,0.60,0.58,0.56,0.54,0.52,0.50 },5,"damageblock",4,0,new int[]{}),
	E111 (111,new double[] { 1.10,1.08,1.06,1.04,1.02,1.00,0.98,0.96,0.94,0.92,0.90,0.88,0.86,0.84,0.82,0.80,0.78,0.76,0.74,0.72,0.70,0.68,0.66,0.64,0.62,0.60,0.58,0.56,0.54,0.52,0.50 },5,"damageblock",4,0,new int[]{}),
	E120 (120,new double[] { 0.50,0.55,0.60,0.65,0.70,0.75,0.80,0.85,0.90,0.95,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00 },10,"itemdrop",4,4,new int[]{270,274,257,285,278}),
	E121 (121,new double[] { 0.50,0.55,0.60,0.65,0.70,0.75,0.80,0.85,0.90,0.95,1.00,1.05,1.10,1.15,1.20,1.25,1.30,1.35,1.40,1.45,1.50,1.55,1.60,1.65,1.70,1.75,1.80,1.85,1.90,1.95,2.00 },10,"itemdrop",1,4,new int[]{270,274,257,285,278}),
	E130 (130,new double[] { 0.70,0.76,0.82,0.88,0.94,1.00,1.06,1.12,1.18,1.24,1.30,1.36,1.42,1.48,1.54,1.60,1.66,1.72,1.78,1.84,1.90,1.96,2.02,2.08,2.14,2.20,2.26,2.32,2.38,2.44,2.50 },5,"itemdrop",16,263,new int[]{270,274,257,285,278}),
	E131 (131,new double[] { 0.70,0.76,0.82,0.88,0.94,1.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00 },5,"itemdrop",15,15,new int[]{274,257,278}),
	E132 (132,new double[] { 0.00,0.00,0.00,0.00,0.00,0.00,1.06,1.12,1.18,1.24,1.30,1.36,1.42,1.48,1.54,1.60,1.66,1.72,1.78,1.84,1.90,1.96,2.02,2.08,2.14,2.20,2.26,2.32,2.38,2.44,2.50 },0,"itemdrop",15,265,new int[]{274,257,278}),
	E140 (140,new double[] { 0.70,0.76,0.82,0.88,0.94,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00 },4,"itemdrop",14,14,new int[]{257,278}),
	E141 (141,new double[] { 0.00,0.00,0.00,0.00,0.00,1.10,1.18,1.26,1.34,1.42,1.50,1.58,1.66,1.74,1.82,1.90,1.98,2.06,2.14,2.22,2.30,2.38,2.46,2.54,2.62,2.70,2.78,2.86,2.94,3.02,3.10 },0,"itemdrop",14,266,new int[]{257,278}),
	E142 (142,new double[] { 0.90,0.94,0.98,1.02,1.06,1.10,1.14,1.18,1.22,1.26,1.30,1.34,1.38,1.42,1.46,1.50,1.54,1.58,1.62,1.66,1.70,1.74,1.78,1.82,1.86,1.90,1.94,1.98,2.02,2.06,2.10 },3,"itemdrop",56,264,new int[]{257,278}),
	E143 (143,new double[] { 3.00,3.30,3.60,3.90,4.20,4.50,4.80,5.10,5.40,5.70,6.00,6.30,6.60,6.90,7.20,7.50,7.80,8.10,8.40,8.70,9.00,9.30,9.60,9.90,10.20,10.50,10.80,11.10,11.40,11.70,12.00 },5,"itemdrop",73,331,new int[]{257,278}),
	E210 (210,new double[] { 1.20,1.16,1.12,1.08,1.04,1.00,0.98,0.96,0.94,0.92,0.90,0.88,0.86,0.84,0.82,0.80,0.78,0.76,0.74,0.72,0.70,0.68,0.66,0.64,0.62,0.60,0.58,0.56,0.54,0.52,0.50 },5,"damageblock",12,0,new int[]{}),
	E211 (211,new double[] { 0.80,0.84,0.88,0.92,0.96,1.00,1.04,1.08,1.12,1.16,1.20,1.24,1.28,1.32,1.36,1.40,1.44,1.48,1.52,1.56,1.60,1.64,1.68,1.72,1.76,1.80,1.84,1.88,1.92,1.96,2.00 },5,"itemdrop",12,12,new int[]{-1,269,273,256,284,277}),
	E220 (220,new double[] { 1.20,1.16,1.12,1.08,1.04,1.00,0.98,0.96,0.94,0.92,0.90,0.88,0.86,0.84,0.82,0.80,0.78,0.76,0.74,0.72,0.70,0.68,0.66,0.64,0.62,0.60,0.58,0.56,0.54,0.52,0.50 },5,"damageblock",13,0,new int[]{}),
	E221 (221,new double[]	{0.95,0.93,0.90,0.88,0.85,0.83,0.80,0.78,0.75,0.73,0.70,0.68,0.65,0.63,0.60,0.58,0.55,0.53,0.50,0.48,0.45,0.43,0.40,0.38,0.35,0.33,0.30,0.28,0.25,0.23,0.20	},5,"itemdrop",13,13,new int[]{-1,269,273,256,284,277}),
	E222 (222,new double[]	{0.05,0.08,0.10,0.13,0.15,0.18,0.23,0.28,0.33,0.38,0.43,0.48,0.53,0.58,0.63,0.68,0.73,0.78,0.83,0.88,0.93,0.98,1.03,1.08,1.13,1.18,1.23,1.28,1.33,1.38,1.43},5,"itemdrop",13,318,new int[]{-1,269,273,256,284,277}),
	E230 (230,new double[] { 1.20,1.16,1.12,1.08,1.04,1.00,0.98,0.96,0.94,0.92,0.90,0.88,0.86,0.84,0.82,0.80,0.78,0.76,0.74,0.72,0.70,0.68,0.66,0.64,0.62,0.60,0.58,0.56,0.54,0.52,0.50 },5,"damageblock",3,0,new int[]{}),
	E231 (231,new double[] { 0.50,0.55,0.60,0.65,0.70,0.75,0.80,0.85,0.90,0.95,1.00,1.05,1.10,1.15,1.20,1.25,1.30,1.35,1.40,1.45,1.50,1.55,1.60,1.65,1.70,1.75,1.80,1.85,1.90,1.95,2.00 },10,"itemdrop",3,3,new int[]{-1,269,273,256,284,277}),
	E232 (232,new double[] { 1.20,1.16,1.12,1.08,1.04,1.00,0.98,0.96,0.94,0.92,0.90,0.88,0.86,0.84,0.82,0.80,0.78,0.76,0.74,0.72,0.70,0.68,0.66,0.64,0.62,0.60,0.58,0.56,0.54,0.52,0.50 },5,"damageblock",2,0,new int[]{}),
	E233 (233,new double[] { 0.50,0.55,0.60,0.65,0.70,0.75,0.80,0.85,0.90,0.95,1.00,1.05,1.10,1.15,1.20,1.25,1.30,1.35,1.40,1.45,1.50,1.55,1.60,1.65,1.70,1.75,1.80,1.85,1.90,1.95,2.00 },10,"itemdrop",2,3,new int[]{-1,269,273,256,284,277}),
	E310 (310,new double[] { 1.20,1.16,1.12,1.08,1.04,1.00,0.98,0.96,0.94,0.92,0.90,0.88,0.86,0.84,0.82,0.80,0.78,0.76,0.74,0.72,0.70,0.68,0.66,0.64,0.62,0.60,0.58,0.56,0.54,0.52,0.50 },5,"damageblock",17,0,new int[]{}),
	E311 (311,new double[] { 1.00,1.00,1.00,1.00,1.00,1.00,1.03,1.06,1.10,1.13,1.16,1.19,1.22,1.26,1.29,1.32,1.35,1.38,1.42,1.45,1.48,1.51,1.54,1.58,1.61,1.64,1.67,1.70,1.74,1.77,1.80 },5,"itemdrop",17,17,new int[]{-1,271,275,258,286,279}),
	E320 (320,new double[] { 3.00,3.00,3.00,3.00,3.00,4.00,4.00,4.00,4.00,4.00,4.00,4.00,4.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00,6.00 },5,"craftitem",5,0,new int[]{}),
	E321 (321,new double[] { 3.00,3.00,3.00,3.00,3.00,4.00,4.00,4.00,4.00,4.00,4.00,4.00,4.00,4.00,4.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,6.00,6.00,6.00,6.00,6.00,6.00 },5,"craftitem",280,0,new int[]{}),
	E410 (410,new double[] { 0.25,0.30,0.35,0.40,0.45,0.50,0.55,0.60,0.65,0.70,0.75,0.80,0.85,0.90,0.95,1.00,1.05,1.10,1.15,1.20,1.25,1.30,1.35,1.40,1.45,1.50,1.55,1.60,1.65,1.70,1.75 },5,"itemdrop",0,295,new int[]{-1}),
	E411 (411,new double[] { 0.20,0.21,0.22,0.23,0.24,0.25,0.26,0.27,0.28,0.29,0.30,0.31,0.32,0.33,0.34,0.35,0.36,0.37,0.38,0.39,0.40,0.41,0.42,0.43,0.44,0.45,0.46,0.47,0.48,0.49,0.50 },30,"itemdrop",0,296,new int[]{-1}),
	E420 (420,new double[] { 0.70,0.76,0.82,0.88,0.94,1.00,1.06,1.12,1.18,1.24,1.30,1.36,1.42,1.48,1.54,1.60,1.66,1.72,1.78,1.84,1.90,1.96,2.02,2.08,2.14,2.20,2.26,2.32,2.38,2.44,2.50 },5,"itemdrop",81,81,new int[]{-1}),
	E421 (421,new double[] { 0.70,0.76,0.82,0.88,0.94,1.00,1.06,1.12,1.18,1.24,1.30,1.36,1.42,1.48,1.54,1.60,1.66,1.72,1.78,1.84,1.90,1.96,2.02,2.08,2.14,2.20,2.26,2.32,2.38,2.44,2.50 },5,"itemdrop",338,338,new int[]{-1}),
	E510 (510,new double[] { 0.60,0.68,0.76,0.84,0.92,1.00,1.08,1.16,1.24,1.32,1.40,1.48,1.56,1.64,1.72,1.80,1.88,1.96,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00 },5,"itemdrop",0,0,new int[]{-1}),
	E511 (511,new double[] { 0.00,0.00,0.00,0.00,0.00,0.00,0.20,0.40,0.60,0.80,1.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00 },10,"itemdrop",53,5,new int[]{-1}),
	E512 (512,new double[] { 0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00 },0,"itemdrop",53,53,new int[]{-1}),
	E513 (513,new double[] { 0.00,0.00,0.00,0.00,0.00,0.00,0.10,0.20,0.30,0.40,0.50,0.60,0.70,0.80,0.90,1.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00 },15,"itemdrop",67,4,new int[]{-1}),
	E514 (514,new double[] { 0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00 },0,"itemdrop",67,67,new int[]{-1}),
	E520 (520,new double[] { 0.00,0.04,0.08,0.12,0.16,0.20,0.24,0.28,0.32,0.36,0.40,0.44,0.48,0.52,0.56,0.60,0.64,0.68,0.72,0.76,0.80,0.84,0.88,0.92,0.96,1.00,1.00,1.00,1.00,1.00,1.00 },0,"itemdrop",0,0,new int[]{-1}),
	E530 (530,new double[] { 1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,3.00,3.00 },5,"craftitem",65,0,new int[]{}),
	E531 (531,new double[] { 1.00,1.00,1.00,1.00,1.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,4.00,4.00,4.00,4.00,4.00,4.00 },5,"craftitem",0,0,new int[]{}),
	E532 (532,new double[] { 3.00,3.00,3.00,3.00,3.00,4.00,4.00,4.00,4.00,4.00,4.00,4.00,4.00,4.00,4.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,5.00,6.00,6.00,6.00,6.00,6.00,6.00 },5,"craftitem",53,0,new int[]{}),
	E610 (610,new double[] { 1.00,1.00,1.00,1.00,1.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,4.00,4.00,4.00,4.00,4.00,4.00 },0,"craftitem",0,0,new int[]{}),
	E620 (620,new double[] { 1.00,1.00,1.00,1.00,1.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,3.00,4.00,4.00,4.00,4.00,4.00,4.00 },0,"craftitem",0,0,new int[]{}),
	E630 (630,new double[] { 1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00 },0,"craftitem",0,0,new int[]{}),
	E631 (631,new double[] { 1.25,1.20,1.15,1.10,1.05,1.00,0.95,0.90,0.85,0.80,0.75,0.70,0.65,0.60,0.55,0.50,0.45,0.40,0.35,0.30,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25 },5,"entitydamaged",0,0,new int[]{}),
	E640 (640,new double[] { 1.20,1.16,1.12,1.08,1.04,1.00,0.96,0.92,0.88,0.84,0.80,0.76,0.72,0.68,0.64,0.60,0.56,0.52,0.48,0.44,0.40,0.36,0.32,0.28,0.25,0.25,0.25,0.25,0.25,0.25,0.25 },5,"itemuse",0,0,new int[]{}),
	E641 (641,new double[] { 1.25,1.20,1.15,1.10,1.05,1.00,0.95,0.90,0.85,0.80,0.75,0.70,0.65,0.60,0.55,0.50,0.45,0.40,0.35,0.30,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25 },5,"entitydamaged",0,0,new int[]{}),
	E650 (650,new double[] { 15.0,16.0,16.0,17.0,17.0,18.0,18.0,19.0,19.0,20.0,20.0,21.0,21.0,22.0,22.0,23.0,23.0,24.0,24.0,25.0,25.0,26.0,26.0,27.0,27.0,28.0,28.0,29.0,29.0,30.0,30.0 },5,"craftitem",66,0,new int[]{}),
	E710 (710,new double[] { 1.00,1.02,1.04,1.06,1.08,1.10,1.12,1.14,1.16,1.18,1.20,1.22,1.24,1.26,1.28,1.30,1.32,1.34,1.36,1.38,1.40,1.42,1.44,1.46,1.48,1.50,1.52,1.54,1.56,1.58,1.60 },0,"vehiclemove",0,0,new int[]{}),
	E711 (711,new double[] { 3.00,3.00,3.00,3.00,3.00,4.00,4.00,4.00,4.00,4.00,5.00,5.00,5.00,5.00,5.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00 },0,"vehicledestroyed",333,5,new int[]{-1}),
	E712 (712,new double[] { 2.00,1.00,1.00,1.00,1.00,1.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00 },0,"vehicledestroyed",0,280,new int[]{-1}),
	E713 (713,new double[] { 0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00 },0,"vehicledestroyed",0,333,new int[]{-1}),
	E720 (720,new double[] { -1.00,-0.90,-0.80,-0.70,-0.60,-0.50,-0.45,-0.40,-0.35,-0.30,-0.25,-0.20,-0.15,-0.10,-0.05,0.00,0.05,0.10,0.15,0.20,0.25,0.30,0.35,0.40,0.45,0.50,0.55,0.60,0.65,0.70,0.75 },15,"entitydamagedbyblock",0,0,new int[]{}),
	E730 (730,new double[] { 2.00,2.00,2.00,2.00,2.00,3.00,3.00,3.00,3.00,3.00,4.00,4.00,4.00,4.00,4.00,5.00,5.00,5.00,5.00,5.00,6.00,6.00,6.00,6.00,6.00,7.00,7.00,7.00,7.00,7.00,8.00 },5,"eatfood",0,0,new int[]{}),
	E731 (731,new double[] { 6.00,6.40,6.80,7.20,7.60,8.00,8.40,8.80,9.20,9.60,10.00,10.40,10.80,11.20,11.60,12.00,12.40,12.80,13.20,13.60,14.00,14.40,14.80,15.20,15.60,16.00,16.40,16.80,17.20,17.60,18.00 },5,"eatfood",0,0,new int[]{}),
	E740 (740,new double[] { 0.95,0.96,0.97,0.98,0.99,1.00,1.01,1.02,1.03,1.04,1.05,1.06,1.07,1.08,1.09,1.10,1.11,1.12,1.13,1.14,1.15,1.16,1.17,1.18,1.19,1.20,1.21,1.22,1.23,1.24,1.25 },5,"itemdrop",37,37,new int[]{-1,0,0,0,0}),
	E741 (741,new double[] { 0.95,0.96,0.97,0.98,0.99,1.00,1.01,1.02,1.03,1.04,1.05,1.06,1.07,1.08,1.09,1.10,1.11,1.12,1.13,1.14,1.15,1.16,1.17,1.18,1.19,1.20,1.21,1.22,1.23,1.24,1.25 },5,"itemdrop",38,38,new int[]{-1,0,0,0,0}),
	E742 (742,new double[] { 0.95,0.96,0.97,0.98,0.99,1.00,1.01,1.02,1.03,1.04,1.05,1.06,1.07,1.08,1.09,1.10,1.11,1.12,1.13,1.14,1.15,1.16,1.17,1.18,1.19,1.20,1.21,1.22,1.23,1.24,1.25 },5,"itemdrop",86,86,new int[]{-1,0,0,0,0}),
	E743 (743,new double[] { 0.95,0.96,0.97,0.98,0.99,1.00,1.01,1.02,1.03,1.04,1.05,1.06,1.07,1.08,1.09,1.10,1.11,1.12,1.13,1.14,1.15,1.16,1.17,1.18,1.19,1.20,1.21,1.22,1.23,1.24,1.25 },5,"itemdrop",91,91,new int[]{-1,0,0,0,0}),
	E810 (810,new double[] { 1.00,1.05,1.10,1.15,1.20,1.25,1.40,1.55,1.70,1.85,2.00,2.15,2.30,2.45,2.60,2.75,2.90,3.05,3.20,3.35,3.50,3.65,3.80,3.95,4.00,4.00,4.00,4.00,4.00,4.00,4.00 },5,"killdrop",0,0,new int[]{}),
	E811 (811,new double[] { 1.25,1.45,1.65,1.85,2.05,2.25,2.45,2.65,2.85,3.05,3.25,3.45,3.65,3.85,4.05,4.25,4.45,4.65,4.85,5.05,5.25,5.45,5.65,5.85,6.00,6.00,6.00,6.00,6.00,6.00,6.00 },5,"killdrop",0,0,new int[]{}),
	E820 (820,new double[] { 1.00,1.10,1.20,1.30,1.40,1.50,1.65,1.80,1.95,2.10,2.25,2.40,2.55,2.70,2.85,3.00,3.15,3.30,3.45,3.60,3.75,3.90,4.05,4.20,4.35,4.50,4.65,4.80,4.95,5.00,5.00 },5,"killdrop",0,0,new int[]{}),
	E821 (821,new double[] { 1.25,1.35,1.45,1.55,1.65,1.75,1.95,2.15,2.35,2.55,2.75,2.95,3.15,3.35,3.55,3.75,3.95,4.15,4.35,4.55,4.75,4.95,5.15,5.35,5.55,5.75,5.95,6.15,6.35,6.55,6.75 },5,"killdrop",0,0,new int[]{}),
	E822 (822,new double[] { 1.25,1.35,1.45,1.55,1.65,1.75,1.95,2.15,2.35,2.55,2.75,2.95,3.15,3.35,3.55,3.75,3.95,4.15,4.35,4.55,4.75,4.95,5.15,5.35,5.55,5.75,5.95,6.15,6.35,6.55,6.75 },5,"killdrop",0,0,new int[]{}),
	E830 (830,new double[] { 0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.20,0.15,0.10,0.05,0.00 },5,"entityattack",0,0,new int[]{}),
	E831 (831,new double[] { 1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,3.00 },5,"craftitem",0,0,new int[]{}),
	E840 (840,new double[] { 0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.20,0.15,0.10,0.05,0.00 },5,"entityattack",0,0,new int[]{}),
	E841 (841,new double[] { 1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,1.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,2.00,3.00 },5,"craftitem",0,0,new int[]{}),
	E850 (850,new double[] { 1.50,1.60,1.70,1.80,1.90,1.00,1.20,1.40,1.60,1.80,2.00,2.20,2.40,2.60,2.80,3.00,3.20,3.40,3.60,3.80,4.00,4.20,4.40,4.60,4.80,5.00,5.20,5.40,5.60,5.80,6.00 },5,"killdrop",0,0,new int[]{}),
	E851 (851,new double[] { 0.00,0.00,0.00,0.00,0.00,1.00,1.00,1.00,1.00,1.00,2.00,2.00,2.00,2.00,2.00,3.00,3.00,3.00,3.00,3.00,4.00,4.00,4.00,4.00,4.00,5.00,5.00,5.00,5.00,5.00,6.00 },5,"killdrop",0,0,new int[]{}),
	E852 (852,new double[] { 1.00,1.05,1.10,1.15,1.20,1.25,1.30,1.35,1.40,1.45,1.50,1.55,1.60,1.65,1.70,1.75,1.80,1.85,1.90,1.95,2.00,2.05,2.10,2.15,2.20,2.25,2.30,2.35,2.40,2.45,2.50 },5,"killdrop",0,0,new int[]{-1,0,0,0,0}),
	E910 (910,new double[] { 1.00,1.38,1.75,2.13,2.50,2.88,3.25,3.63,4.00,4.38,4.75,5.10,5.50,5.88,6.25,6.63,7.00,7.38,7.75,8.13,8.50,8.88,9.00,9.00,9.00,9.00,9.00,9.00,9.00,9.00,9.00 },0,"civic",0,0,new int[]{}),
	E920 (920,new double[] { 5.00,10.0,15.0,20.0,25.0,30.0,35.0,40.0,45.0,50.0,55.0,60.0,65.0,70.0,75.0,80.0,85.0,90.0,95.0,100.,105.,110.,115.,120.,125.,130.,135.,140.,144.,144.,144. },0,"civic",0,0,new int[]{}),
	E990 (990,new double[] { 1.00,1.06,1.12,1.18,1.24,1.30,1.36,1.42,1.48,1.54,1.60,1.66,1.72,1.78,1.84,1.90,1.96,2.02,2.08,2.14,2.20,2.26,2.32,2.38,2.44,2.50,2.56,2.62,2.68,2.74,2.80 },5,"itemdrop",0,0,new int[]{278});
	
    public final int effectId;
    public final double[] effects;
    public final int elfEffectLevel;
    public final String effectType;
    public final int searchedItemId;
    public final int createdItemId;
    public final int[] allowableTools;

    SkillEffects(
		 int effectId,
		 double[] effects,
		 int elfEffectLevel,
		 String effectType,
		 int searchedItemId,
		 int createdItemId,
		 int[] allowableTools
		 )
	{
	    this.effectId = effectId;
	    this.effects = effects;
	    this.elfEffectLevel = elfEffectLevel;
	    this.effectType = effectType;
	    this.searchedItemId = searchedItemId;
	    this.createdItemId = createdItemId;
	    this.allowableTools = allowableTools;
	    
	}

	public double getEffectValue(int effectLevel){
	    return this.effects[effectLevel];
	}

	public int getElfLevel(int effectId){
	    return this.elfEffectLevel;
	}

	/*
	 * Returns all effects that trigger on specific effect type and specific item
	 */
	public static List<SkillEffects> getEffects(int itemId, String effectType){
		//int[] outputArray;
		List<SkillEffects> outputArray = new ArrayList<SkillEffects>();
		for(SkillEffects s : SkillEffects.values())
			if(s.searchedItemId == itemId && effectType.equalsIgnoreCase(s.effectType))
			outputArray.add(s);
		return outputArray;
	}
	
	/*
	 * Returns the output item for effects that have an item output
	 */
	public int getEffectResult(int effectId){
		return this.createdItemId;
	}
	
	
	public Skills getSkillForEffect() {
	    int skillId = (this.effectId - (this.effectId % 10))/10;
	    Skills skill = Skills.getSkillBySkillId(skillId);
	    return skill;
	}

	public int getRandomBlockCount(int playerSkillLevel){
		Random generator = new Random();
		double blockChance = this.getEffectValue(playerSkillLevel);
		int wholeBlocks = (int)Math.floor(blockChance);
		double partBlocks = blockChance % 1;
		double rand = generator.nextDouble();
		if(partBlocks >= rand){wholeBlocks++;};
		return wholeBlocks;
	}

}