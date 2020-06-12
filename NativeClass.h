
// The following ifdef block is the standard way of creating macros which make exporting 
// from a DLL simpler. All files within this DLL are compiled with the NATIVECLASS_EXPORTS
// symbol defined on the command line. this symbol should not be defined on any project
// that uses this DLL. This way any other project whose source files include this file see 
// NATIVECLASS_API functions as being imported from a DLL, wheras this DLL sees symbols
// defined with this macro as being exported.
#ifdef NATIVECLASS_EXPORTS
#define NATIVECLASS_API __declspec(dllexport)
#else
#define NATIVECLASS_API __declspec(dllimport)
#endif

// This class is exported from the NativeClass.dll
class NATIVECLASS_API CNativeClass {
public:
	CNativeClass(void);
	// TODO: add your methods here.
};

extern NATIVECLASS_API int nNativeClass;

NATIVECLASS_API int fnNativeClass(void);

