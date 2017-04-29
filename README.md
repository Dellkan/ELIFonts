WORK IN PROGRESS
========
Excuse the mess.

(This project still has a long way to go, and doesn't work as described just yet. Stay tuned.)

Purpose
========
Apply custom fonts to views in layout xml files. This is done through [ELI (Enhanced Layout Inflater)](https://github.com/Dellkan/EnhancedLayoutInflater).

Setup
========
_TODO_

```java
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(new ELIContextWrapper(newBase, new ELIConfig.Builder()
                .addHook(new FontHook("fonts/my_default_font.ttf"))
                .build()));
    }
}
```

```xml
<TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Default. Should apply defaulted font" />

<TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Test 1 (Candy)"
    app:font="fonts/candy.ttf" />

<TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Test 2 (Scriptina)"
    app:font="fonts/scriptina.ttf" />

<TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="TextAppearance test"
    android:textAppearance="@style/textStyleWithFont" />
```

Weirdness, caveats and other peculiar behaviours
========
 - Doesn't currently work for ActionBarTitle. This is not because the ActionBarTitle is weird in 
 any way, and can't support font's, but just that it's created in a weird way that isn't picked up by
 the ELI library.

Todo:
========
 - Fix ActionBarTitle issue
 - Test more plattforms for compatibility
 - Account for latest font changes in latest android versions

Similar libraries
========
 - [Calligraphy](https://github.com/chrisjenx/Calligraphy) Does the exact same thing this library 
 does, only Calligraphy does it way better (it's mature, where this library is only getting started).  